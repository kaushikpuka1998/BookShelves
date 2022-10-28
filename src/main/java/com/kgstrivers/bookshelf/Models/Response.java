package com.kgstrivers.bookshelf.Models;

public class Response {

    Boolean success;
    Bookdetails bookdetails;

    public Response() {
    }

    public Response(Boolean success, Bookdetails bookdetails) {
        this.success = success;
        this.bookdetails = bookdetails;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Bookdetails getBookdetails() {
        return bookdetails;
    }

    public void setBookdetails(Bookdetails bookdetails) {
        this.bookdetails = bookdetails;
    }
}
