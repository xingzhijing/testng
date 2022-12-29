package com.xzj.service;

import com.alibaba.fastjson.JSONArray;
import com.xzj.dto.ObjectCaseDTO;

import java.io.IOException;

public interface IOrderCaseDataBizService {
    /**
     * 新增运单
     * */
    JSONArray saveOrderCaseData(ObjectCaseDTO objectCaseDTO) throws IOException;
}
