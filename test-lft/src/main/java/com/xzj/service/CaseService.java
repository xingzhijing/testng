package com.xzj.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.entity.CaseData;
import com.xzj.log.LogConfig;

import java.io.IOException;
import java.util.List;

public interface CaseService extends IService<CaseData> {
    List<CaseData> getCaseListByCondition(Integer id);

    JSONArray getCaseListByParam(String protocol) throws IOException;

//    Boolean updateCaseRunState(Integer id);
}
