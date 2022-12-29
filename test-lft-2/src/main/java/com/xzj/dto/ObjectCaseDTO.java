package com.xzj.dto;

import lombok.Data;

import java.util.List;

/**
 * 司机用例参数实例
 * */
@Data
public class ObjectCaseDTO {
    private String companyId;

    private String departmentId;

    private String dataType;

    private List<Long> ids;
}
