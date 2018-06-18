package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRepository;
import com.intern.miniproject.entity.Room;
import com.intern.miniproject.result.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import com.github.wenhao.jpa.Specifications;

import java.util.Objects;
import java.util.Calendar;

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
    public ResultJson getRoomList(@RequestParam(value="subject") Integer subject,
                                  @RequestParam(value="deadline_type") Integer deadline_type,
                                  @RequestParam(value="money") Integer money,
                                  @RequestParam(value="location") Integer location) {
        long deadline = 0;
        if (Objects.nonNull(deadline_type)) {
            Calendar rightNow = Calendar.getInstance();
            rightNow.add(Calendar.DAY_OF_YEAR, deadline_type);//日期加1/7/30天
            deadline = rightNow.getTime().getTime();
        }
        Specification<Room> specification = Specifications.<Room>and()
                .eq("subject", subject)
                .lt(Objects.nonNull(deadline_type), "deadline", deadline)
                .lt(Objects.nonNull(money), "money", money)
                .eq(Objects.nonNull(location), "location", location)
                .eq("user.street")
                .build();
        return new ResultJson(true, "Successful", roomRepository.findAll(specification));
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
