package com.kgstrivers.bookshelf.Repository;

import com.kgstrivers.bookshelf.Models.Bookdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Bookdetails, Long> {
}
