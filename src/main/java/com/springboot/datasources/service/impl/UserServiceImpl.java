package com.springboot.datasources.service.impl;

import com.springboot.datasources.dao.db1.User1Dao;
import com.springboot.datasources.dao.db2.User2Dao;
import com.springboot.datasources.entity.DBEnum;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by L.Answer on 2018-12-09 15:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User1Dao user1Dao;

    @Autowired
    private User2Dao user2Dao;

    @Override
    public List<UserEntity> findUserList(DBEnum dbEnum, Map<String, Object> params) {
        if (dbEnum == DBEnum.DB2){
            return user2Dao.findRecordsBySelectKeys(params);
        }
        return user1Dao.findRecordsBySelectKeys(params);
    }

    @Override
    public UserEntity findUserById(DBEnum dbEnum, Long id) {
        if (dbEnum == DBEnum.DB2){
            return user2Dao.findByPrimaryKey(id);
        }

        return user1Dao.findByPrimaryKey(id);
    }

    @Override
    public int insertUser(DBEnum dbEnum, UserEntity userEntity) {
        if (dbEnum == DBEnum.DB2){
            return user2Dao.insertSingleRecord(userEntity);
        }
        return user1Dao.insertSingleRecord(userEntity);
    }

    @Override
    public int updateUser(DBEnum dbEnum, UserEntity entity) {
        if (dbEnum == DBEnum.DB2){
            return user2Dao.updateByRecord(entity);
        }
        return user1Dao.updateByRecord(entity);
    }

    @Override
    public int deleteUserById(DBEnum dbEnum, Long id) {
        if (dbEnum == DBEnum.DB2){
            return user2Dao.deleteByPrimaryKey(id);
        }
        return user1Dao.deleteByPrimaryKey(id);
    }
}