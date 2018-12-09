package com.springboot.mapper;

import com.springboot.datasources.entity.DBEnum;
import com.springboot.datasources.entity.UserEntity;
import com.springboot.datasources.entity.UserSexEnum;
import com.springboot.datasources.service.UserService;
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
    private UserService userService;

    @Test
    public void testInsert() throws Exception {
        userService.insertUser(DBEnum.DB1, new UserEntity("jim", "a123456", UserSexEnum.MAN));
        userService.insertUser(DBEnum.DB1, new UserEntity("jane", "b123456", UserSexEnum.WOMAN));
        userService.insertUser(DBEnum.DB1, new UserEntity("james", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userService.findUserList(DBEnum.DB1, null));
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userService.findUserList(DBEnum.DB1, null);
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(users.size());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userService.findUserById(DBEnum.DB1, 3L);
        if (user != null) {
            System.out.println(user.toString());
            user.setNickName("answer");
            userService.updateUser(DBEnum.DB1, user);
            Assert.assertTrue(("answer".equals(userService.findUserById(DBEnum.DB1, 3L).getNickName())));
        }
    }
}