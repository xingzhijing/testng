package com.xzj.service;

import com.alibaba.fastjson.JSONArray;
import com.xzj.dto.ObjectCaseDTO;

import java.io.IOException;

public interface IDriverCaseDataBizService {
    JSONArray saveDriverCaseData(ObjectCaseDTO objectCaseDTO) throws IOException;
}
