package com.xzj.mysql.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private long id;

    private String userName;

    private int age;

    private String address;

    private Date createTime;

    private Date updateTime;
}

