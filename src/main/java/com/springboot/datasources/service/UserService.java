package com.springboot.datasources.service;

import com.springboot.datasources.entity.UserEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by L.Answer on 2018-12-07 15:20
 */
public interface UserService {

    List<UserEntity> findUserList(HashMap<String, Object> params);

    UserEntity findUserById(Long id);

    int insertUser(UserEntity userEntity);

    int updateUser(UserEntity entity);

    int deleteUserById(Long id);

}