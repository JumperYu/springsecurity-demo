package com.bradypod.web;

import com.bradypod.domain.dto.SecurityUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bradpod
 * @version 2019/09/18
 */
@RestController
public class UserController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok("hello ".concat(securityUserDetails.getUsername()));
    }
}
