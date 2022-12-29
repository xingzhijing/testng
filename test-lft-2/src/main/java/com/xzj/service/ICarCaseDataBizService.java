package com.xzj.service;

import com.alibaba.fastjson.JSONArray;
import com.xzj.dto.ObjectCaseDTO;

import java.io.IOException;

public interface ICarCaseDataBizService {
    /**
     * 新增司机
     * */
    JSONArray saveCarCaseData(ObjectCaseDTO objectCaseDTO) throws IOException;
}
