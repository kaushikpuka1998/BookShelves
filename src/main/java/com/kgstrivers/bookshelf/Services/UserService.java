package com.kgstrivers.bookshelf.Services;

import com.kgstrivers.bookshelf.Models.Role;
import com.kgstrivers.bookshelf.Models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoletoUser(String username,String rolename);
    User getUser(String username);
    List<User>getUsers();
}
