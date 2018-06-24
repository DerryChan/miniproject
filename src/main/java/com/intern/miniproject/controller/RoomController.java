package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRepository;
import com.intern.miniproject.entity.Room;
//import com.intern.miniproject.service.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
    public List<Room> getRoomList(@RequestParam(value="subject") Integer subject,
                                  @RequestParam(value="location") String location) {
        return roomRepository.findAllFilter(subject, location);
    }

    /**
     * Get All Rooms
     *
     * @return
     */
    @GetMapping(value = "/getRoomList")
    public List<Room> getRoomList(@RequestParam(value="subject") Integer subject) {
        return roomRepository.findBySubjectOrderByPublishTimeDesc(subject);
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
        //String url = uploadImg(roomUrl);
        Room room = new Room(roomUrl, publishTime, location, rentWay, subject, rtx, money, deadline, description);
        return roomRepository.save(room);
    }

    @GetMapping(value = "/getRoomByRoomId")
    public Room getRoomByRoomId(@RequestParam("roomId") Integer roomId) {
        return roomRepository.findByRoomId(roomId);
    }

    @GetMapping(value = "/getRoomByRtx")
    public List<Room> getRoomListByRtx(@RequestParam(value="rtx") String rtx,
                                       @RequestParam(value="subject") Integer subject) {
        return roomRepository.findBySubjectAndRtxOrderByPublishTimeDesc(subject, rtx);
    }
}
