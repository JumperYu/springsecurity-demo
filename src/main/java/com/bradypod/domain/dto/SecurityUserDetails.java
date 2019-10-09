package com.bradypod.domain.dto;

import com.bradypod.domain.model.User;
import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author https://github.com/JumperYu
 * @version 2019/10/09
 */
public class SecurityUserDetails implements UserDetails, Serializable {
    private String username;
    private String password;
    private boolean enabled;

    private List<SimpleGrantedAuthority> authorities;

    public SecurityUserDetails(User user) {
        Assert.notNull(user, "user is required");

        this.authorities = Lists.newArrayList();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getStatus() == 1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
