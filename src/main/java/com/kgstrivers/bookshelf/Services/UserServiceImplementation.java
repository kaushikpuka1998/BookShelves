package com.kgstrivers.bookshelf.Services;

import com.kgstrivers.bookshelf.Models.Role;
import com.kgstrivers.bookshelf.Models.User;
import com.kgstrivers.bookshelf.Repository.RolesRepo;
import com.kgstrivers.bookshelf.Repository.UserRepo;
import com.kgstrivers.bookshelf.RestControllers.APIControllers;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class UserServiceImplementation implements UserService, UserDetailsService {

    private static Logger log = LogManager.getLogger(UserServiceImplementation.class);
    private final UserRepo userRepo;
    private final RolesRepo rolesRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        log.info("saveUser()");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saveRole()");
        return rolesRepo.save(role);
    }

    @Override
    public void addRoletoUser(String username, String rolename) {

        log.info("addRoletoUser()");
        User user = userRepo.findByUsername(username);
        Role role = rolesRepo.findByName(rolename);

        user.getRoles().add(role);

        log.info("Roles Inserted into User's Rolelist");
    }

    @Override
    public User getUser(String username) {
        log.info("getUser()");
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("getUsers()");
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null)
        {
            log.error("NO User Find named as"+username);
            throw new UsernameNotFoundException("User not found in Database");
        }
        else{
            log.error("User Find named as"+username);
        }
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
