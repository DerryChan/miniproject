package com.intern.miniproject.dao;

import com.intern.miniproject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer>  {
    public List<Message> findByToRtxOrderByTimestampDesc(String rtx);
}
