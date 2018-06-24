//package com.intern.miniproject.controller;
//import com.intern.miniproject.service.FileUtil;
//import com.intern.miniproject.service.SpringContextUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//@Controller
//public class UploadController {
//    @Autowired
//    private HttpServletRequest request;
//
//    @RequestMapping("/test")
//    public String pages(){
//        return "sys/uploadimg";
//    }
//
//
//    @PostMapping(value = "/uploadFile")
//    public String uploadImg(@RequestParam(value="file")MultipartFile file) {
//        if (file.isEmpty()) {
//            return null;
//        }else {
//            String fileName = file.getOriginalFilename();  //图片名字
//
//            //保存时的文件名
//            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//            Calendar calendar = Calendar.getInstance();
//            String dateName = df.format(calendar.getTime())+file.getOriginalFilename();
//
//            System.out.println(dateName);
//            //保存文件的绝对路径
//            WebApplicationContext webApplicationContext = (WebApplicationContext)SpringContextUtils.applicationContext;
//            ServletContext servletContext = webApplicationContext.getServletContext();
//            String realPath = servletContext.getRealPath("/");
//            String filePath = realPath + "WEB-INF"+File.separator + "classes" + File.separator +"static" + File.separator + "resource" + File.separator+dateName;
//            System.out.println("绝对路径:"+filePath);
//            //File newFile = new File(filePath);
//            try {
//                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//            } catch (Exception e) {
//                // TODO: handle exception
//            }
//
//            //MultipartFile的方法直接写文件
////            try {
////                //上传文件
////                file.transferTo(newFile);
//
////                //数据库存储的相对路径
////                String projectPath = servletContext.getContextPath();
////                String contextpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+projectPath;
////                String url = contextpath + "/resources/"+dateName;
////                System.out.println("相对路径:"+url);
////                //文件名与文件URL存入数据库表
////                return null;
////            } catch (IllegalStateException | IOException e) {
////                e.printStackTrace();
////            }
//
//        }
//        return null;
//    }
//}