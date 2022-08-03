package com.xzj.dto;

import lombok.Data;

@Data
public class GetUserListCase {
    private String userName;
    private Integer age;
    private String address;
    private String expect;
}
