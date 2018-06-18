package com.intern.miniproject.result;

/**
 * Created by Derry on 2018/6/17.
 */
public class ResultJson {
    private Boolean status;
    private String message;
    private Object result;

    public ResultJson(Boolean status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ResultJson() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
