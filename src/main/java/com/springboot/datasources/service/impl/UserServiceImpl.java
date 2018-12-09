package com.springboot.datasources.service.impl;

import com.springboot.datasources.dao.db1.User1Dao;
import com.springboot.datasources.dao.db2.User2Dao;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by L.Answer on 2018-12-09 15:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User1Dao user1Dao;

    @Override
    public List<UserEntity> findUserList(HashMap<String, Object> params) {
        return user1Dao.findRecordsBySelectKeys(params);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return user1Dao.findByPrimaryKey(id);
    }

    @Override
    public int insertUser(UserEntity userEntity) {
        return user1Dao.insertSingleRecord(userEntity);
    }

    @Override
    public int updateUser(UserEntity entity) {
        return user1Dao.updateByRecord(entity);
    }

    @Override
    public int deleteUserById(Long id) {
        return user1Dao.deleteByPrimaryKey(id);
    }
}