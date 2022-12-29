package com.xzj.dao.service.department;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.dao.entity.DepartmentData;

public interface DepartmentDataService extends IService<DepartmentData> {
    DepartmentData getByDepartmentId(String departmentId);

}
