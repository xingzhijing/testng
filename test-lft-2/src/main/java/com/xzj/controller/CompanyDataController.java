package com.xzj.controller;

import com.xzj.common.Result;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.service.company.CompanyDataService;
import com.xzj.service.ICompanyDataBizService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companyData")
public class CompanyDataController {
    @Autowired
    private ICompanyDataBizService companyDataBizService;

    @GetMapping("/query/{companyId}")
    public Result<CompanyData> queryCompanyDataController(@PathVariable(value = "companyId") String companyId){
        if (StringUtils.isBlank(companyId)) {
            return Result.fail();
        }

        // TODO 获取当前登录用户信息

        return Result.succeed(companyDataBizService.getByCompanyId(companyId));
    }

}
