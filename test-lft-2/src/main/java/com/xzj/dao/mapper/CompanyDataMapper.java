package com.xzj.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xzj.dao.entity.CompanyData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface CompanyDataMapper extends BaseMapper<CompanyData> {

    /**
     * 为了测试类写的，lft接口测试中没有用到
     * 参数：@Param(Constants.WRAPPER) 等价于 @Param("ew")
     * */
    @Select("select company_key, company_secret from company_data ${ew.customSqlSegment} ")
    Map<String, String> findByConditions(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
//    Map<String, String> findByConditions(@Param("ew") QueryWrapper queryWrapper);

    /**
     * 为了测试类写的，lft接口测试中没有用到
     * */
    @Update("update ${tableName} set ${ew.sqlSet} ${ew.customSqlSegment}")
//    int updateByConditions(@Param("tableName") String tableName, @Param(Constants.WRAPPER) Wrapper wrapper);
    int updateByConditions(@Param("tableName") String tableName, @Param("ew") Wrapper wrapper);



}
