package com.kgstrivers.bookshelf.RestControllers;

import com.kgstrivers.bookshelf.Models.Role;
import com.kgstrivers.bookshelf.Models.User;
import com.kgstrivers.bookshelf.Services.UserService;
import com.kgstrivers.bookshelf.Services.UserServiceImplementation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    @Data
    class RoleToUsername{
        private String username;
        private String rolename;

    }


}
