package com.xzj.mapper;

import com.xzj.entity.TestData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDataMapper {
    List<TestData> findTestDataById(String sql);
}
