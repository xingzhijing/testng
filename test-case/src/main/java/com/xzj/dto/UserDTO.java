package com.xzj.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    private String userName;

    private Integer age;

    private String address;

    private Date createTime;

    private Date updateTime;

}

