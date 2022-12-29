package com.xzj.service;

import com.xzj.dao.entity.CompanyData;

public interface ICompanyDataBizService {
    CompanyData getByCompanyId(String companyId);
}
