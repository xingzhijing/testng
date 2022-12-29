package com.xzj.dao.service.company;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.dao.entity.CompanyData;

public interface CompanyDataService extends IService<CompanyData> {
    CompanyData getByCompanyId(String companyId);
}
