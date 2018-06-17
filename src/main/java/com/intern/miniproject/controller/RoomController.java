package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRepository;
import com.intern.miniproject.entity.Room;
import com.intern.miniproject.result.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Get All Rooms
     *
     * @return
     */
    @GetMapping(value = "/getRoomList")
    public ResultJson getRoomList() {
        return new ResultJson(true, "Successful", roomRepository.findAll());
    }

    /**
     * New Room
     *
     * @param publishTime
     * @param location
     * @param rentWay
     * @param subject
     * @param rtx
     * @param money
     * @param deadline
     * @param description
     * @return
     */
    @PostMapping(value = "/addNewRoom")
    public ResultJson addNewRoom(@RequestParam("publishTime") long publishTime,
                                 @RequestParam("location") String location,
                                 @RequestParam("rentWay") Integer rentWay,
                                 @RequestParam("subject") Integer subject,
                                 @RequestParam("rtx") String rtx,
                                 @RequestParam("money") Integer money,
                                 @RequestParam("deadline") Long deadline,
                                 @RequestParam("description") String description) {
        Room room = new Room(publishTime, location, rentWay, subject, rtx, money, deadline, description);
        return new ResultJson(true, "Successful", roomRepository.save(room));

    }

}
