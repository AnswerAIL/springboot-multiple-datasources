package com.springboot.mapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by L.Answer on 2018-12-07 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DB2MapperTest {
/**

    @Autowired
    private User2Mapper userMapper;

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
        if (user != null) {
            System.out.println("id: " + user.getId());
            user.setNickName("answer");
            userMapper.update(user);
            Assert.assertTrue(("answer".equals(userMapper.getOne(3L).getNickName())));
        }
    }
*/

}