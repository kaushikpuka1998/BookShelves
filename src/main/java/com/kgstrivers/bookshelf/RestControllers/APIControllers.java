package com.kgstrivers.bookshelf.RestControllers;
import com.kgstrivers.bookshelf.Models.Bookdetails;
import com.kgstrivers.bookshelf.Repository.Bookrepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

    @PutMapping("/updatedata/{id}")
    public Bookdetails updateBook(@PathVariable long id, @RequestBody Bookdetails bookdetails)
    {
        log.info("=======================Entered into updateBook() Function=========================");
        Bookdetails selectedbook = bookrepo.findById(id).get();
        selectedbook.setBookname(bookdetails.getBookname());
        selectedbook.setAuthor(bookdetails.getAuthor());
        selectedbook.setIsbn_no(bookdetails.getIsbn_no());
        selectedbook.setLink(bookdetails.getLink());
        selectedbook.setPublisher(bookdetails.getPublisher());
        selectedbook.setPrice(bookdetails.getPrice());

        bookrepo.save(selectedbook);

        log.info("Data"+selectedbook+ "inserted into DB====");
        return selectedbook;


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
