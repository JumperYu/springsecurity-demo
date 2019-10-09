package com.bradypod.config;

import com.bradypod.service.impl.SecurityUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //  本地UserDetails
        //  InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //  manager.createUser(User.withUsername("admin").password("{noop}123456").roles("admin").build());
        //  return manager;

        return new SecurityUserServiceImpl();
    }

    @Bean
    @SuppressWarnings("deprecation")
    PasswordEncoder passwordEncoder() {
        String idForEncode = "noop";
        Map<String, PasswordEncoder> encoders = new HashMap<>(4);
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put(idForEncode, NoOpPasswordEncoder.getInstance());

        return new DelegatingPasswordEncoder(idForEncode, encoders);
    }
}
