package com.intern.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.intern.miniproject.entity", "com.intern.miniproject.controller",
//        "com.intern.miniproject.dao", "com.intern.miniproject"})

@SpringBootApplication
public class MiniprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprojectApplication.class, args);
    }
}
