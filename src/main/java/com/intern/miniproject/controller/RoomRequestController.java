package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRequestRepository;
import com.intern.miniproject.entity.RoomRequest;
import com.intern.miniproject.result.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
@RequestMapping(value = "/roomRequest")
public class RoomRequestController {
    @Autowired
    private RoomRequestRepository roomRequestRepository;

    /**
     * Get All Room Request
     *
     * @return
     */
    @GetMapping(value = "/getRoomRequestList")
    public ResultJson getRoomList() {
        return new ResultJson(true, "Successful", roomRequestRepository.findAll());
    }

    /**
     * @param budget
     * @param suitableTime
     * @param location
     * @param description
     * @return
     */
    @PostMapping(value = "/addNewRoomRequest")
    public ResultJson addNewRoom(@RequestParam("budget") Integer budget,
                                 @RequestParam("suitableTime") Integer suitableTime,
                                 @RequestParam("location") Integer location,
                                 @RequestParam("description") String description) {
        RoomRequest roomRequest = new RoomRequest(budget, suitableTime, location, description);
        return new ResultJson(true, "Successful", roomRequestRepository.save(roomRequest));

    }
}
