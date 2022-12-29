package com.xzj.dao.service.object;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.dao.entity.ObjectCaseData;

import java.util.List;

public interface ObjectCaseDataService extends IService<ObjectCaseData> {
    /**
    * 查询多条数据
     * @param ids 多条用例的id
     * @param dataType 查询的业务类型，1 司机 2 载具  3 运单
    */
    List<ObjectCaseData> listByIds(List<Long> ids, String dataType);

//    @Override
//    boolean updateById(ObjectCaseData entity);
}
