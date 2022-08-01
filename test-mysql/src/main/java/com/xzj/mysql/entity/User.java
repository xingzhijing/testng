package com.xzj.mysql.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private long id;

    private String userName;

    private int age;

    private String address;

    private Date createTime;

    private Date updateTime;
}
