package com.kgstrivers.bookshelf.RestControllers;


import com.kgstrivers.bookshelf.BookshelfApplication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIControllers {

    private static Logger log = LogManager.getLogger(APIControllers.class);
    @GetMapping("/")
    public String welcome()
    {
        log.info("=======================Entered into Welcome Function=========================");
        return "Welcome";
    }
}
