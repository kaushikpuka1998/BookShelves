package com.kgstrivers.bookshelf.Models;

public class ErrorResponse {

    Boolean res;
    String msg;

    public ErrorResponse(Boolean res, String msg) {
        this.res = res;
        this.msg = msg;
    }

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
