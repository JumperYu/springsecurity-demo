package com.bradypod.service.impl;

import com.bradypod.domain.dto.SecurityUserDetails;
import com.bradypod.domain.model.User;
import com.bradypod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username.concat(" is not found"));
        }
        return new SecurityUserDetails(user);
    }
}
