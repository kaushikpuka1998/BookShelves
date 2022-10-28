package com.kgstrivers.bookshelf.RestControllers;
import com.kgstrivers.bookshelf.Models.Bookdetails;
import com.kgstrivers.bookshelf.Models.ErrorResponse;
import com.kgstrivers.bookshelf.Models.Response;
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
    public Response getparticularBook(@PathVariable long id)
    {
        log.info("=======================Entered into getparticularBook() Function=========================");
        Response res = new Response();
        try{
            Bookdetails bookdetails = bookrepo.findById(id).get();
            log.info("======Entered id:"+id+"'s Data got Picked");
            res = new Response(true,bookdetails);
        }
        catch(Exception e)
        {
            res = new Response(false,null);
        }

        return res;
    }

    @PostMapping("/save")
    public Response saveBooks(@RequestBody Bookdetails bookdetails)
    {

        log.info("=======================Entered into saveBooks() Function=========================");
        try{
            bookrepo.save(bookdetails);

            log.info("Data"+bookdetails+ "inserted into DB====");
            return new Response(true, bookdetails);
        }
        catch (Exception e)
        {
            log.error("Error with Exception in Save:" + e);
            return new Response(false,null);
        }

    }

    @PutMapping("/updatedata/{id}")
    public Response updateBook(@PathVariable long id, @RequestBody Bookdetails bookdetails)
    {
        try{
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
            return new Response(true,selectedbook);
        }
        catch (Exception e)
        {
            log.error("Error with Exception in Update:" + e);
            return new Response(false,null);
        }



    }

    @DeleteMapping("/delete/{id}")
    public Response deleteBook(@PathVariable long id)
    {
        try{
            log.info("=======================Entered into deleteBook() Function=========================");
            Bookdetails bookdetails = bookrepo.findById(id).get();
            bookrepo.delete(bookdetails);

            log.info("======Entered id:"+id+"'s Data got deleted");

            Response res = new Response(true,bookdetails);
            return res;
        }
        catch(Exception e)
        {
            log.error("Error with Exception in Delete:" + e);
            return new Response(false,null);
        }

    }


}
