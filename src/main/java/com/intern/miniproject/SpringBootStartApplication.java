package com.intern.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Derry on 2018/6/20.
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(MiniprojectApplication.class);
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MiniprojectApplication.class, args);
    }
}