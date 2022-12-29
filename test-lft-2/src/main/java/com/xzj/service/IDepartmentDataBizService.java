package com.xzj.service;

import com.xzj.dao.entity.DepartmentData;

public interface IDepartmentDataBizService {
    DepartmentData getByDepartmentId(String departmentId);
}
