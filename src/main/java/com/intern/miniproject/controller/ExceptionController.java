//package com.intern.miniproject.controller;
//
///**
// * Created by Derry on 2018/6/23.
// */
//
//import com.intern.miniproject.result.ResultJson;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//@AllArgsConstructor
//public class ExceptionController {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    /**
//     * 抛出错误前，打印错误日志
//     * **/
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResultJson handleException(Exception exception){
//        logger.error(exception.getMessage(), exception);
//        return new ResultJson(false, exception.getMessage(), null);
//    }
//
//}
//
