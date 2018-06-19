package com.intern.miniproject.dao;

import com.intern.miniproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Derry on 2018/6/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByRtx(String rtx);
}
