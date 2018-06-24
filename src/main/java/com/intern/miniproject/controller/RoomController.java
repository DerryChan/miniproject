package com.intern.miniproject.controller;

import com.intern.miniproject.dao.RoomRepository;
import com.intern.miniproject.entity.Room;
import com.intern.miniproject.service.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Derry on 2018/6/17.
 */
@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取求租/出租流
     *
     * @param subject
     * @return
     */
    @GetMapping(value = "/filterAllRoom")
    public List<Room> getRoomList(@RequestParam(value="subject") Integer subject,
                                  @RequestParam(value="location") String location) {
        return roomRepository.findAllFilter(subject, location);
    }

    /**
     * Get All Rooms
     *
     * @return
     */
    @GetMapping(value = "/getRoomList")
    public List<Room> getRoomList(@RequestParam(value="subject") Integer subject) {
        return roomRepository.findBySubjectOrderByPublishTimeDesc(subject);
    }

    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    @GetMapping(value = "/uploadFile")
    public String uploadImg(@RequestParam(value="file")MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }else {

            //保存时的文件名
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String dateName = df.format(calendar.getTime())+file.getOriginalFilename();

            System.out.println(dateName);
            //保存文件的绝对路径
            WebApplicationContext webApplicationContext = (WebApplicationContext)SpringContextUtils.applicationContext;
            ServletContext servletContext = webApplicationContext.getServletContext();
            String realPath = servletContext.getRealPath("/");
            String filePath = realPath + "WEB-INF"+File.separator + "classes" + File.separator +"static" + File.separator + "resource" + File.separator+dateName;
            System.out.println("绝对路径:"+filePath);

            File newFile = new File(filePath);

            //MultipartFile的方法直接写文件
            try {
                //上传文件
                file.transferTo(newFile);

                //数据库存储的相对路径
                String projectPath = servletContext.getContextPath();
                String contextpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+projectPath;
                String url = contextpath + "/resources/"+dateName;
                System.out.println("相对路径:"+url);
                //文件名与文件URL存入数据库表
                return url;
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        }
        return null;
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
    public Room addNewRoom(@RequestParam("publishTime") long publishTime,
                                 @RequestParam("roomUrl") MultipartFile roomUrl,
                                 @RequestParam("location") String location,
                                 @RequestParam("rentWay") Integer rentWay,
                                 @RequestParam("subject") Integer subject,
                                 @RequestParam("rtx") String rtx,
                                 @RequestParam("money") Integer money,
                                 @RequestParam("deadline") Long deadline,
                                 @RequestParam("description") String description) {
        String url = uploadImg(roomUrl);
        Room room = new Room(url, publishTime, location, rentWay, subject, rtx, money, deadline, description);
        return roomRepository.save(room);
    }

    @GetMapping(value = "/getRoomByRoomId")
    public Room getRoomByRoomId(@RequestParam("roomId") Integer roomId) {
        return roomRepository.findByRoomId(roomId);
    }

    @GetMapping(value = "/getRoomByRtx")
    public List<Room> getRoomListByRtx(@RequestParam(value="rtx") String rtx,
                                       @RequestParam(value="subject") Integer subject) {
        return roomRepository.findBySubjectAndRtxOrderByPublishTimeDesc(subject, rtx);
    }
}
