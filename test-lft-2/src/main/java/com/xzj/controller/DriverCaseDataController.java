package com.xzj.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzj.common.Result;
import com.xzj.dto.ObjectCaseDTO;
import com.xzj.service.IDriverCaseDataBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/driver")
public class DriverCaseDataController {
    @Autowired
    IDriverCaseDataBizService IDriverCaseDataBizService;

    @PostMapping("/save")
    public Result saveDriverCaseData(@RequestBody ObjectCaseDTO objectCaseDTO) throws IOException {
        JSONArray jsonArray = IDriverCaseDataBizService.saveDriverCaseData(objectCaseDTO);
        if (!jsonArray.isEmpty()){
            return Result.succeed(jsonArray);
        }else {
            return Result.fail("-1", "接口测试失败", jsonArray);
        }
    }

}
