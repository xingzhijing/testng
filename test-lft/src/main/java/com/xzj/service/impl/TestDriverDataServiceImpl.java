package com.xzj.service.impl;

import com.xzj.dto.TestDataDTO;
import com.xzj.mapper.TestDataMapper;
import com.xzj.service.TestDriverDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriverDataServiceImpl implements TestDriverDataService {
    @Autowired
    private TestDataMapper testDataMapper;

    @Override
    public List<TestDataDTO> getTestDriverDataOneById(String sql) {
        List<TestDataDTO> testDataDTOList = testDataMapper.findTestDataById(sql);
        System.out.println(testDataDTOList);
        return testDataDTOList;
    }
}
