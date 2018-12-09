package com.springboot.datasources.controller;

import com.springboot.datasources.entity.DBEnum;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.service.UserService;
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
    private UserService userService;



    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        LOGGER.info("getUsers...");
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(1, 1);
        params.put("pageInfo", pageInfo);
        return userService.findUserList(DBEnum.DB1, params);
    }


    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        return userService.findUserById(DBEnum.DB2, id);
    }


    @RequestMapping("/add")
    public void save(UserEntity user) {
        int count = userService.insertUser(DBEnum.DB2, user);
        LOGGER.info("insert count: {}.", count);
    }


    @RequestMapping(value="update")
    public void update(UserEntity user) {
        int count = userService.updateUser(DBEnum.DB2, user);
        LOGGER.info("update count: {}.", count);
    }


    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        int count = userService.deleteUserById(DBEnum.DB1, id);
        LOGGER.info("delete count: {}.", count);
    }


}