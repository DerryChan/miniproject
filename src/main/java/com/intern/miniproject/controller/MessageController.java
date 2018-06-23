package com.intern.miniproject.controller;

import com.intern.miniproject.dao.MessageRepository;
import com.intern.miniproject.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Get All Rooms
     *
     * @return
     */
    @GetMapping(value = "/getMessageList")
    public List<Message> getRoomList(@RequestParam(value="rtx") String rtx) {
        return messageRepository.findByToRtxOrderByTimestampDesc(rtx);
    }

    @GetMapping(value = "/addMessage")
    public Message addMessageList(@RequestParam("fromRtx") String fromRtx,
                                  @RequestParam("toRtx") String toRtx,
                                  @RequestParam("message") String message) {
        Date now = new Date();
        Message msg = new Message(fromRtx, toRtx, message, now.getTime());
        return messageRepository.save(msg);
    }
}
