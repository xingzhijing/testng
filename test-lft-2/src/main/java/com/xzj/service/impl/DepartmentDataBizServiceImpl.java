package com.xzj.service.impl;

import com.xzj.dao.entity.DepartmentData;
import com.xzj.dao.service.department.DepartmentDataService;
import com.xzj.service.IDepartmentDataBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDataBizServiceImpl implements IDepartmentDataBizService {
    @Autowired
    DepartmentDataService departmentDataService;
    @Override
    public DepartmentData getByDepartmentId(String departmentId) {
        return departmentDataService.getByDepartmentId(departmentId);
    }
}
