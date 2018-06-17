package com.intern.miniproject.dao;

import com.intern.miniproject.entity.RoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Derry on 2018/6/17.
 */
public interface RoomRequestRepository extends JpaRepository<RoomRequest, Integer> {
}
