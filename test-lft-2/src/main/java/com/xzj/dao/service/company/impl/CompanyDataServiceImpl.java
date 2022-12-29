package com.xzj.dao.service.company.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.mapper.CompanyDataMapper;
import com.xzj.dao.service.company.CompanyDataService;
import org.springframework.stereotype.Service;


@Service
public class CompanyDataServiceImpl extends ServiceImpl<CompanyDataMapper, CompanyData> implements CompanyDataService {

    /**
     * 查找集团信息
     * */
    public CompanyData getByCompanyId(String companyId){
        LambdaQueryWrapper<CompanyData> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CompanyData::getCompanyId, companyId);
        return getOne(queryWrapper, false);
    }

}
