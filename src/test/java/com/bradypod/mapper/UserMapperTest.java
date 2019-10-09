package com.bradypod.mapper;

import com.bradypod.SpringSecurityDemoApplication;
import com.bradypod.domain.mapper.UserMapper;
import com.bradypod.domain.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * userMapper testcase
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSecurityDemoApplication.class)
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    static final String USERNAME = "JumperYu";

    @Test
    public void test01() {
        User user = new User();
        user.setUsername("JumperYu").setPassword("{noop}123456").setStatus(1).setCreateTime(new Date()).setUpdateTime(new Date()).setVersion(1L);
        int rows = userMapper.save(user);
        Assert.assertEquals(1, rows);
    }

    @Test
    public void test02() {
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encodedPassword = encoder.encode("123456");
        user.setUsername("xue").setPassword("{bcrypt}".concat(encodedPassword)).setStatus(1).setCreateTime(new Date()).setUpdateTime(new Date()).setVersion(1L);
        int rows = userMapper.save(user);
        Assert.assertEquals(1, rows);
    }

    /**
     * 按名字查询查询
     */
    @Test
    public void test03() {
        User user = userMapper.getByUsername(USERNAME);
        Assert.assertNotNull(user);
    }
}
