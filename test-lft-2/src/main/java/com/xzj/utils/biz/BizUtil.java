package com.xzj.utils.biz;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzj.dao.entity.CaseDataResultEnum;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.mapper.ObjectCaseDataMapper;
import com.xzj.dao.service.object.ObjectCaseDataService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
/**
 * 业务工具
 * */
@Component
public class BizUtil<T> implements Serializable {
    @Autowired
    ObjectCaseDataService objectCaseDataService;

    /**
     * 拼接Url
     * */
    public static String IntegrateUrl(String host, String uri){
        return host.concat(uri);
    }

    /**
     * 更新测试用例数据
     * @param id 测试用例数据id;
     * @param actualResult 接口返回的实际结果
     * */
    public static UpdateWrapper<ObjectCaseData> updateCaseData(@NonNull Long id, @NonNull JSONObject actualResult){
        UpdateWrapper<ObjectCaseData> objectCaseDataUpdateWrapper = new UpdateWrapper<>();
        objectCaseDataUpdateWrapper.eq("id", id)
                .set("actual_result", actualResult.toString())
                .set("is_run", CaseDataResultEnum.PASS.codeValue)
                .set("update_time", new Date());
        return objectCaseDataUpdateWrapper;
    }
}
