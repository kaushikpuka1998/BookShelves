package com.kgstrivers.bookshelf.RestControllers;


import com.kgstrivers.bookshelf.BookshelfApplication;
import com.kgstrivers.bookshelf.Models.Bookdetails;
import com.kgstrivers.bookshelf.Repository.Bookrepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class APIControllers {

    private static Logger log = LogManager.getLogger(APIControllers.class);

    @Autowired
    private Bookrepo bookrepo;
    @GetMapping("/")
    public String welcome()
    {
        log.info("=======================Entered into welcome() Function=========================");
        return "Welcome";
    }

    @GetMapping("/allbooks")
    public List<Bookdetails> bookslist()
    {
        log.info("=======================Entered into bookslist() Function=========================");
        return bookrepo.findAll();
    }

    @GetMapping("/books/{id}")
    public Bookdetails getparticularBook(@PathVariable long id)
    {
        log.info("=======================Entered into getparticularBook() Function=========================");
        Bookdetails bookdetails = bookrepo.findById(id).get();

        log.info("======Entered id:"+id+"'s Data got Picked");
        return bookdetails;
    }

    @PostMapping("/save")
    public Bookdetails saveBooks(@RequestBody Bookdetails bookdetails)
    {
        log.info("=======================Entered into saveBooks() Function=========================");
        bookrepo.save(bookdetails);

        log.info("Data"+bookdetails+ "inserted into DB====");
        return bookdetails;
    }

    @DeleteMapping("/delete/{id}")
    public Bookdetails deleteBook(@PathVariable long id)
    {
        log.info("=======================Entered into deleteBook() Function=========================");
        Bookdetails bookdetails = bookrepo.findById(id).get();
        bookrepo.delete(bookdetails);

        log.info("======Entered id:"+id+"'s Data got deleted");
        return bookdetails;
    }
}
