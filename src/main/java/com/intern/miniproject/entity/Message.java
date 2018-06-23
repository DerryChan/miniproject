package com.intern.miniproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Derry on 2018/6/15.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;
    private String fromRtx;
    private String toRtx;
    private String msg;
    private long timestamp;

    public Message() {
    }
    //必须要有构造函数
    public Message(String fromRtx, String toRtx, String msg, long timestamp) {
        this.fromRtx = fromRtx;
        this.toRtx = toRtx;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromRtx() {
        return fromRtx;
    }

    public void setFromRtx(String name) {
        this.fromRtx = fromRtx;
    }

    public String getToRtx() {
        return toRtx;
    }

    public void setToRtx(Integer age) {
        this.toRtx = toRtx;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(Integer age) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
