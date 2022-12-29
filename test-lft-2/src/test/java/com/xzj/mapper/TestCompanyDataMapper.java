package com.xzj.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzj.LFTApplication_2;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.mapper.CompanyDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = LFTApplication_2.class)
public class TestCompanyDataMapper extends AbstractTestNGSpringContextTests {
    @Autowired
    CompanyDataMapper companyDataMapper;

    @Test
    public void testQueryCompanyAll(){
        List<CompanyData> companyDataList = companyDataMapper.selectList(null);
        System.out.println("===========开始输出companyDataList===========");
        companyDataList.forEach(System.out::println);
    }

    /**
     * 只查询一条数据
     * */
    @Test
    public void testQueryCompanyOne(){
        QueryWrapper<CompanyData> queryWrapper = new QueryWrapper<CompanyData>();
        queryWrapper.eq("company_id", "1941");
        CompanyData companyDataOne = companyDataMapper.selectOne(queryWrapper);
        System.out.println("===========开始输出companyDataOne===========");
        System.out.println(companyDataOne);
    }

    @Test
    public void testQueryCompanyListObjs(){
        QueryWrapper<CompanyData> queryWrapper = new QueryWrapper<CompanyData>();
        queryWrapper.eq("company_id", "1941");
        List<Object> companyDataListObjs = companyDataMapper.selectObjs(queryWrapper);
        System.out.println("===========开始输出companyDataObjs===========");
        System.out.println(companyDataListObjs);
    }

    @Test
    public void testFindByConditions(){
        QueryWrapper<CompanyData> queryWrapper = new QueryWrapper<CompanyData>();
        queryWrapper.eq("id", "1");
        Map<String, String>  companyDataMapperByConditions = companyDataMapper.findByConditions(queryWrapper);
        System.out.println("===========开始输出companyDataMapperByConditions===========");
        System.out.println(companyDataMapperByConditions);
    }

    /**
     * 更新字段值
     * */
    @Test
    public void testUpdateByConditions(){
        UpdateWrapper<CompanyData> updateWrapper = new UpdateWrapper<>();
        Integer updateId = companyDataMapper.updateByConditions("company_data", updateWrapper.set("company_id", "1942").eq("id", "1"));
        System.out.println("==> 开始输出companyDataMapperByConditions");
        System.out.println(updateId);
    }

    @Test
    public void testQueryCompanyListByMap(){
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("id", 1);
        List companyDataList = companyDataMapper.selectByMap(columnMap);
        System.out.println("companyDataList: ===> " + companyDataList);
    }

}
