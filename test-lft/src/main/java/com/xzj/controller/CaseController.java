package com.xzj.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzj.entity.CaseData;
import com.xzj.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class CaseController {

    @Autowired
    CaseService caseService;

    @GetMapping("/add")
    public JSONArray addDriver(@RequestParam(name = "host") String host) throws IOException {
        return caseService.getCaseListByParam(host);
    }

    @GetMapping("/add/id/{id}")
    public List<CaseData> addDriverById(@PathVariable("id") Integer id) throws IOException {
        return caseService.getCaseListByCondition(id);
    }

}
