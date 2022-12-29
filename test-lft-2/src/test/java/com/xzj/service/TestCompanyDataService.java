package com.xzj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzj.LFTApplication_2;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.service.company.CompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = LFTApplication_2.class)
public class TestCompanyDataService extends AbstractTestNGSpringContextTests {
    @Autowired
    CompanyDataService companyDataService;

    @Test
    public void testQueryCompanyDataServiceMap(){
        QueryWrapper<CompanyData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_id", "1941");
        CompanyData companyData = companyDataService.getOne(queryWrapper);
        System.out.println("testQueryCompanyDataServiceMap =====> " + companyData.getClass());
        System.out.println("testQueryCompanyDataServiceMap =====> " + companyData.getCompanyId());
    }
}
