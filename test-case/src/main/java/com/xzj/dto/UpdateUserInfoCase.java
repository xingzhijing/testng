package com.xzj.dto;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private Long userId;
    private String userName;
    private Integer age;
    private String address;
    private Integer isDelete;
    private String expect;
}
