package com.xzj.mapper;

import com.xzj.dto.TestDataDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDataMapper {
    List<TestDataDTO> findTestDataById(String sql);
}
