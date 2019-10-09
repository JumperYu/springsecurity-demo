package com.bradypod.domain.mapper;

import com.bradypod.base.domain.mapper.BaseMapper;
import com.bradypod.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 使用用户名查找用户
     *
     * @param username - 用户名
     * @return {@link User}
     */
    User getByUsername(String username);
}
