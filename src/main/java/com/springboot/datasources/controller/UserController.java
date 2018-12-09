package com.springboot.datasources.controller;

import com.springboot.datasources.dao.db1.User1Dao;
import com.springboot.datasources.dao.db2.User2Dao;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by L.Answer on 2018-12-07 11:07
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private User1Dao user1Dao;

    @Autowired
    private User2Dao user2Dao;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        LOGGER.info("getUsers...");
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(1, 1);
        params.put("pageInfo", pageInfo);
        List<UserEntity> users=user1Dao.getAll(params);
        return users;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        UserEntity user=user2Dao.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Dao.insert(user);
    }

    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Dao.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Dao.delete(id);
    }

}