package com.liebe.test;

import com.alibaba.fastjson.JSON;
import com.liebe.sys.entity.User;
import com.liebe.sys.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Before
    public void testInsert() {
        User user = new User();
        user.setUsername("mahuateng");
        user.setPassword("123456");
        userService.insert(user);
//        Assert.assertNotNull(person.getId());
        logger.debug(JSON.toJSONString(user));
    }


    @Test
    public void testFindList() {
        User user = new User();
        List<User> users= userService.findList(user);
//        Assert.assertNotNull(persons);
        logger.debug(JSON.toJSONString(users));
    }
}
