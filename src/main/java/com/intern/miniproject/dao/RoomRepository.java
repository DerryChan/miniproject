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
    public List<Room> findBySubjectOrderByPublishTimeDesc(Integer subject);
    public List<Room> findBySubjectAndRtxOrderByPublishTimeDesc(Integer subject, String rtx);

    @Query(value = "select Room.* from Room where subject=?1 and location like %?2% order by publish_time desc", nativeQuery = true)
    public List<Room> findAllFilter(Integer subject, String location);

}
