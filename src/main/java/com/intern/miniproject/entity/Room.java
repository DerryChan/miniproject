package com.intern.miniproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Derry on 2018/6/17.
 */
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Integer roomId;
    private String roomUrl;
    private long publishTime;
    private String location;
    private Integer rentWay;
    private Integer subject;
    private String rtx;
    private Integer money;
    private long deadline;
    private String description;

    public Room() {
    }

    public Room(String roomUrl, long publishTime, String location, Integer rentWay, Integer subject, String rtx, Integer money, long deadline, String description) {
        this.roomUrl = roomUrl;
        this.publishTime = publishTime;
        this.location = location;
        this.rentWay = rentWay;
        this.subject = subject;
        this.rtx = rtx;
        this.money = money;
        this.deadline = deadline;
        this.description = description;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRentWay() {
        return rentWay;
    }

    public void setRentWay(Integer rentWay) {
        this.rentWay = rentWay;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getRtx() {
        return rtx;
    }

    public void setRtx(String rtx) {
        this.rtx = rtx;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
