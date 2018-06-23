package com.intern.miniproject.entity;

/**
 * Created by Derry on 2018/6/23.
 */
public class RequestMessage {
    private String name;

    public RequestMessage(String name) {
        this.name = name;
    }

    public RequestMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
