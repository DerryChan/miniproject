package com.intern.miniproject.dao;

import com.intern.miniproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Derry on 2018/6/15.
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
    public List<Person> findByAge(Integer age);
}