package com.xzj.service.impl;

import com.xzj.dto.TestDataDTO;
import com.xzj.entity.TestData;
import com.xzj.mapper.TestDataMapper;
import com.xzj.service.TestDriverDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriverDataServiceImpl implements TestDriverDataService {
    @Autowired
    private TestDataMapper testDataMapper;

    @Override
    public List<TestData> getTestDriverDataOneById(String sql) {
        List<TestData> testDataList = testDataMapper.findTestDataById(sql);
//        拷贝无效，处理比较麻烦，暂时不处理 TODO
//        List<TestDataDTO> testDataDTOList = new ArrayList<>();
//        BeanUtils.copyProperties(testDataList, testDataDTOList);
        return testDataList;

    }
}
