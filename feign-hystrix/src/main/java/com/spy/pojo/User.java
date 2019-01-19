package com.spy.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2018/12/25.
 */
public class User {
    private Long id;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
        this.date=new Date();

    }
}
