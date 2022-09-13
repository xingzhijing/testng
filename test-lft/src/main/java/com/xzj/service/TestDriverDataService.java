package com.xzj.service;


import com.xzj.dto.TestDataDTO;
import com.xzj.entity.TestData;

import java.util.List;

public interface TestDriverDataService {
//    查找一条司机测试用例
    List<TestData> getTestDriverDataOneById(String sql);
}
