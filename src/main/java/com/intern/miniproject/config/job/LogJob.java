//package com.intern.miniproject.config.job;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by Derry on 2018/6/23.
// */
//@Component
//public class LogJob {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * 2秒钟执行1次
//     */
////    @Scheduled(fixedRate = 2 * 1000)
//    public void logging(){
//        Date now = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        logger.info(simpleDateFormat.format(now));
//        logger.debug("-------DEBUG---------");
//        logger.error("" + now.getTime());
//    }
//
//}
