package com.intern.miniproject.controller;

import com.intern.miniproject.dao.UserRepository;
import com.intern.miniproject.dao.MessageRepository;
import com.intern.miniproject.entity.Message;
import com.intern.miniproject.entity.User;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.shiro.authc.*;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private MessageRepository messageRepository;

    /**
     * Login
     *
     * @param rtx
     * @param outlookPwd
     * @return
     */
    @PostMapping(value = "/login")
    public Boolean login(@RequestParam("rtx") String rtx,
                         @RequestParam("outlookPwd") String outlookPwd) {
        User user = userRepository.findByRtx(rtx);
        if (user.getOutlookPwd().equals(outlookPwd)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping(value = "/login_test")
    public Boolean login_test(@RequestParam("rtx") String rtx,
                            @RequestParam("outlookPwd") String outlookPwd) {
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        UsernamePasswordToken token = new UsernamePasswordToken(rtx, outlookPwd);
        token.setRememberMe(true);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 开始由 Shiro 帮助我们完成身份认证的逻辑
            currentUser.login(token);
            System.out.println("登录成功！");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("无效的用户名");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("错误的密码");
        }catch (AuthenticationException e){
            e.printStackTrace();
        }

        return true;
    }

    /**
     * get user
     * @param rtx
     * @return
     */
    @GetMapping(value = "/getUserByRtx")
    public User getUserByRtx(@RequestParam("rtx") String rtx) {
        return userRepository.findByRtx(rtx);
    }
}
