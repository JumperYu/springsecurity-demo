package com.bradypod.service;

import com.bradypod.base.service.BaseMybatisService;
import com.bradypod.domain.model.User;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
public interface UserService extends BaseMybatisService<User> {

    /**
     * 根据账号获取用户
     *
     * @param username - 账号名
     * @return {@link User}
     */
    User loadUserByUsername(String username);
}
