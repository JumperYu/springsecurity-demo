package com.bradypod.domain.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * userMapper testcase
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@Data
@Accessors(chain = true)
public class User implements java.io.Serializable {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Long version;
}

