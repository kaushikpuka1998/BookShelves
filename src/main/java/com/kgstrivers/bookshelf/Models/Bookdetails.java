package com.kgstrivers.bookshelf.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bookname;
    private String isbn_no;
    private String author;
    private String link;
    private String publisher;
    private String price;

    public Bookdetails() {
    }

    public Bookdetails(long id, String bookname, String isbn_no, String author, String link, String publisher, String price) {
        this.id = id;
        this.bookname = bookname;
        this.isbn_no = isbn_no;
        this.author = author;
        this.link = link;
        this.publisher = publisher;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIsbn_no() {
        return isbn_no;
    }

    public void setIsbn_no(String isbn_no) {
        this.isbn_no = isbn_no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
