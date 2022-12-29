package com.xzj.dao.service.department.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.dao.entity.DepartmentData;
import com.xzj.dao.mapper.DepartmentDataMapper;
import com.xzj.dao.service.department.DepartmentDataService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDataServiceImpl extends ServiceImpl<DepartmentDataMapper, DepartmentData> implements DepartmentDataService {

    /**
     * 查找子公司信息
     * */
    @Override
    public DepartmentData getByDepartmentId(String departmentId) {
        LambdaQueryWrapper<DepartmentData> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(DepartmentData::getDepartmentId, departmentId);
        return getOne(queryWrapper, false);
    }
}
