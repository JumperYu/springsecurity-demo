package com.bradypod.service;

import com.bradypod.SpringSecurityDemoApplication;
import com.bradypod.domain.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * userMapper testcase
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSecurityDemoApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    static final String USERNAME = "JumperYu";

    @Test
    public void test01() {
        User user = userService.loadUserByUsername(USERNAME);
        Assert.assertNotNull(user);
    }
}
