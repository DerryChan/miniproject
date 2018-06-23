package com.intern.miniproject.dao;

import com.intern.miniproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Derry on 2018/6/17.
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
    public Room findByRoomId(Integer roomId);

    @Query(value = "select Room.*, User.icon from Room left join User on Room.rtx=User.rtx"
            +" where Room.subject=?1 order by Room.publish_time desc", nativeQuery = true)
    public List<Room> findAll(Integer subject);

    @Query(value = "select Room.*, User.icon from Room left join User on Room.rtx=User.rtx"
            +" where Room.subject=?1 and Room.location like %?2% order by Room.publish_time desc", nativeQuery = true)
    public List<Room> findAllFilter(Integer subject, String location);

    @Query(value = "select Room.*, User.icon from Room left join User on Room.rtx=User.rtx"
            +" where Room.rtx=?1 and Room.subject=?2 order by Room.publish_time desc", nativeQuery = true)
    public List<Object> findByRtxAndSubject(String rtx, Integer subject);
}
