package com.springboot.datasources.dao.db1;

import com.springboot.datasources.entity.UserEntity;

import java.util.List;

/**
 * Created by L.Answer on 2018-12-07 10:09
 */
public interface User1Mapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);


}