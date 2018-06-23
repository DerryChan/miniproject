package com.intern.miniproject.controller;

import com.intern.miniproject.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private PersonProperties personProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return personProperties.getName() + personProperties.getAge();
    }
}