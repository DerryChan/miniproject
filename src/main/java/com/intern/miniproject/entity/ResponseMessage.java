package com.intern.miniproject.entity;

/**
 * Created by Derry on 2018/6/23.
 */
public class ResponseMessage {
    private String responseMessage;

    public ResponseMessage() {
    }

    public ResponseMessage(String responseMessage) {

        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
