package com.intern.miniproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Derry on 2018/6/17.
 */
@Entity
public class RoomRequest {
    @Id
    @GeneratedValue
    private Integer roomRequestId;
    private Integer budget;
    private Integer suitableTime; //0 立即入住 1 一周内入住 2一月内入住
    private Integer location; //0 滨海 1 腾大万利达 2 飞亚达 3 科兴
    private String description;

    public RoomRequest() {
    }

    public RoomRequest(Integer budget, Integer suitableTime, Integer location, String description) {
        this.budget = budget;
        this.suitableTime = suitableTime;
        this.location = location;
        this.description = description;
    }

    public Integer getRoomRequestId() {
        return roomRequestId;
    }

    public void setRoomRequestId(Integer roomRequestId) {
        this.roomRequestId = roomRequestId;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getSuitableTime() {
        return suitableTime;
    }

    public void setSuitableTime(Integer suitableTime) {
        this.suitableTime = suitableTime;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
