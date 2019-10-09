package com.bradypod.service.impl;

import com.bradypod.base.service.BaseMybatisServiceImpl;
import com.bradypod.domain.mapper.UserMapper;
import com.bradypod.domain.model.User;
import com.bradypod.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
@Service
public class UserServiceImpl extends BaseMybatisServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User loadUserByUsername(String username) {

        Assert.hasText(username, "username is required");

        return getMapper().getByUsername(username);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
}