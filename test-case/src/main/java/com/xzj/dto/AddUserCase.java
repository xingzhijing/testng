package com.xzj.dto;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private Integer age;
    private String address;
    private Integer isDelete;
    private String expect;
}
