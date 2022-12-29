package com.xzj.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzj.common.Result;
import com.xzj.dto.ObjectCaseDTO;
import com.xzj.service.ICarCaseDataBizService;
import com.xzj.service.IDriverCaseDataBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/car")
public class CarCaseDataController {
    @Autowired
    ICarCaseDataBizService carCaseDataBizService;

    @PostMapping("/save")
    public Result saveDriverCaseData(@RequestBody ObjectCaseDTO objectCaseDTO) throws IOException {
        JSONArray jsonArray = carCaseDataBizService.saveCarCaseData(objectCaseDTO);
        if (!jsonArray.isEmpty()){
            return Result.succeed(jsonArray);
        }else {
            return Result.fail("-1", "接口测试失败", jsonArray);
        }
    }

}
