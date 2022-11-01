package com.xzj.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xzj.entity.CompanyData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface CompanyDataMapper extends BaseMapper<CompanyData> {

    @Select("select company_key, company_secret from company_data ${ew.customSqlSegment} ")
    Map<String, String> findByCompanyId(@Param(Constants.WRAPPER)LambdaQueryWrapper lambdaQueryWrapper);
}
