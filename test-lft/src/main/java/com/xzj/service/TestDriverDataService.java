package com.xzj.service;


import com.xzj.dto.TestDataDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public interface TestDriverDataService {
//    查找一条司机测试用例
    List<TestDataDTO> getTestDriverDataOneById(String sql);
}
