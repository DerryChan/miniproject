package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRepository;
import com.intern.miniproject.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    /**
     * 获取求租/出租流
     *
     * @param subject
     * @return
     */
    @GetMapping(value = "/filterAllRoom")
    public List<Object> getRoomList(@RequestParam(value="subject") Integer subject,
                                  @RequestParam(value="location") String location) {
        return roomRepository.findAllFilter(subject, location);
    }

    /**
     * Get All Rooms
     *
     * @return
     */
    @GetMapping(value = "/getRoomList")
    public List<Object> getRoomList(@RequestParam(value="subject") Integer subject) {
        return roomRepository.findAll(subject);
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
    public Room addNewRoom(@RequestParam("publishTime") long publishTime,
                                 @RequestParam("roomUrl") String roomUrl,
                                 @RequestParam("location") String location,
                                 @RequestParam("rentWay") Integer rentWay,
                                 @RequestParam("subject") Integer subject,
                                 @RequestParam("rtx") String rtx,
                                 @RequestParam("money") Integer money,
                                 @RequestParam("deadline") Long deadline,
                                 @RequestParam("description") String description) {
        Room room = new Room(roomUrl, publishTime, location, rentWay, subject, rtx, money, deadline, description);
        return roomRepository.save(room);
    }

    @GetMapping(value = "/getRoomByRoomId")
    public Room getRoomByRoomId(@RequestParam("roomId") Integer roomId) {
        return roomRepository.findByRoomId(roomId);
    }

    @GetMapping(value = "/getRoomByRtx")
    public List<Object> getRoomListByRtx(@RequestParam(value="rtx") String rtx,
                                       @RequestParam(value="subject") Integer subject) {
        return roomRepository.findByRtxAndSubject(rtx, subject);
    }
}
