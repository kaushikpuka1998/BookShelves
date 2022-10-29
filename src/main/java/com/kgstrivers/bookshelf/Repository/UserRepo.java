package com.kgstrivers.bookshelf.Repository;

import com.kgstrivers.bookshelf.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
