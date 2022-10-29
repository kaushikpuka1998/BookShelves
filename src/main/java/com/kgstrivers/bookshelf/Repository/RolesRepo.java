package com.kgstrivers.bookshelf.Repository;

import com.kgstrivers.bookshelf.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
