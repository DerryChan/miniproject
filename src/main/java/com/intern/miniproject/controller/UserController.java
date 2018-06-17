package com.intern.miniproject.controller;

import com.intern.miniproject.dao.UserRepository;
import com.intern.miniproject.entity.User;
import com.intern.miniproject.result.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Login
     *
     * @param rtx
     * @param outlookPwd
     * @return
     */
    @PostMapping(value = "/login")
    public ResultJson login(@RequestParam("rtx") String rtx,
                            @RequestParam("outlookPwd") String outlookPwd) {
        User user = userRepository.findByRtx(rtx);
        if (user.getOutlookPwd().equals(outlookPwd)) {
            return new ResultJson(true, "Login Successful", null);
        } else {
            return new ResultJson(false, "Login Failed, Please check your password or rtx", null);
        }
    }

}
