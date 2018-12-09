package com.springboot.datasources.service;

import com.springboot.datasources.entity.DBEnum;
import com.springboot.datasources.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by L.Answer on 2018-12-07 15:20
 */
public interface UserService {

    List<UserEntity> findUserList(DBEnum dbEnum, Map<String, Object> params);

    UserEntity findUserById(DBEnum dbEnum, Long id);

    int insertUser(DBEnum dbEnum, UserEntity userEntity);

    int updateUser(DBEnum dbEnum, UserEntity entity);

    int deleteUserById(DBEnum dbEnum, Long id);

}