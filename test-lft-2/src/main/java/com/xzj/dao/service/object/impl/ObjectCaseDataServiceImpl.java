package com.xzj.dao.service.object.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.dao.mapper.ObjectCaseDataMapper;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.service.object.ObjectCaseDataService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  ServiceImpl<ObjectCaseDataMapper, ObjectCaseData>   默认传输了DriverCaseDataMapper
 * */

@Service
public class ObjectCaseDataServiceImpl extends ServiceImpl<ObjectCaseDataMapper, ObjectCaseData> implements ObjectCaseDataService {
    /**
     * 查询多条参数
     * */
    @Override
    public List<ObjectCaseData> listByIds(List<Long> ids, String dataType) {
        LambdaQueryWrapper<ObjectCaseData> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(ObjectCaseData::getId, ids).eq(ObjectCaseData::getDataType, dataType);
        return this.list(queryWrapper);
    }

//    @Override
//    public boolean updateById(ObjectCaseData objectCaseData) {
//        UpdateWrapper<ObjectCaseData> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq(objectCaseData.getId()).set()
//    }
}
