package com.intern.miniproject.dao;

import com.intern.miniproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Derry on 2018/6/15.
 */

public interface PersonRepository extends JpaRepository<Person, Integer> {
    /**
     * 通过年龄来查询
     * 方法名固定findByAge
     *
     * @param age
     * @return
     */
    public List<Person> findByAge(Integer age);


}