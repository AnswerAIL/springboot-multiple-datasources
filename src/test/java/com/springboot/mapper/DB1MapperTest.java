package com.springboot.mapper;

import com.springboot.datasources.dao.db1.User1Mapper;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.entity.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by L.Answer on 2018-12-07 14:11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DB1MapperTest {
    @Autowired
    private User1Mapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new UserEntity("jim", "a123456", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("jane", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("james", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userMapper.getAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.size());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userMapper.getOne(3L);
        System.out.println(user.toString());
        user.setNickName("answer");
        userMapper.update(user);
        Assert.assertTrue(("answer".equals(userMapper.getOne(3L).getNickName())));
    }
}