package com.kgstrivers.bookshelf.RestControllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgstrivers.bookshelf.Models.Role;
import com.kgstrivers.bookshelf.Models.User;
import com.kgstrivers.bookshelf.Services.UserService;
import com.kgstrivers.bookshelf.Services.UserServiceImplementation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPIController {

    private static Logger log = LogManager.getLogger(UserAPIController.class);
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUser(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        log.info("saveUser()");
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }


    @PostMapping("/role/savetoUser")
    public ResponseEntity addRoletoUser(@RequestBody RoleToUsername usernamerole)
    {
        userService.addRoletoUser(usernamerole.username, usernamerole.rolename);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String authorisationHeader =  request.getHeader(AUTHORIZATION);
        if(authorisationHeader != null && authorisationHeader.startsWith("Bearer "))
        {
            try{
                String refresh_token = authorisationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);

                String access_token = JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 10*60*1000)).withIssuer(request.getRequestURL().toString()).withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList())).sign(algorithm);
                Map<String,String> tokens = new HashMap<>();

                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(),tokens);

            }catch(Exception e)
            {
                log.info("Catch Case");
                log.error("Error in logging"+e.getMessage());
                response.setHeader("error",e.getMessage());
                //response.sendError(FORBIDDEN.value());
                response.setStatus(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error_message",e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
        }
        else{

            throw new RuntimeException("Refresh Token Missing");
        }
    }
    @Data
    class RoleToUsername{
        private String username;
        private String rolename;

    }


}
