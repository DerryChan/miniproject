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
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    /**
     * 获取求租/出租流
     *
     * @param subject
     * @return
     */
    @GetMapping(value = "/allRoom")
    public ResultJson getRoomList(@RequestParam(value="subject") Integer subject
//                                  @RequestParam(value="deadline") long deadline,
//                                  @RequestParam(value="money") Integer money,
//                                  @RequestParam(value="location") Integer location
    ) {

        return new ResultJson(true, "Successful", roomRepository.getBySubject(subject));
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
    public ResultJson addNewRoom(@RequestParam("roomUrl") String roomUrl,
                                 @RequestParam("publishTime") long publishTime,
                                 @RequestParam("location") String location,
                                 @RequestParam("rentWay") Integer rentWay,
                                 @RequestParam("subject") Integer subject,
                                 @RequestParam("rtx") String rtx,
                                 @RequestParam("money") Integer money,
                                 @RequestParam("deadline") Long deadline,
                                 @RequestParam("description") String description) {
        //room image url handler
        Room room = new Room(roomUrl, publishTime, location, rentWay, subject, rtx, money, deadline, description);
        return new ResultJson(true, "Successful", roomRepository.save(room));
    }

    @GetMapping(value = "/room")
    public ResultJson getRoomListByRtx(@RequestParam(value="rtx") String rtx,
                                       @RequestParam(value="subject") Integer subject) {
        return new ResultJson(true, "Successful", roomRepository.findByRtxAndSubject(rtx, subject));
    }
}
