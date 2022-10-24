package com.kgstrivers.bookshelf.RestControllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIControllers {
    @GetMapping("/")
    public String welcome()
    {
        return "Welcome";
    }
}
