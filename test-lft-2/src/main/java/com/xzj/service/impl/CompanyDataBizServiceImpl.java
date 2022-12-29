package com.xzj.service.impl;

import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.service.company.CompanyDataService;
import com.xzj.service.ICompanyDataBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyDataBizServiceImpl implements ICompanyDataBizService {

    @Autowired
    private CompanyDataService companyDataService;

    @Override
    public CompanyData getByCompanyId(String companyId) {
        return companyDataService.getByCompanyId(companyId);
    }

}
