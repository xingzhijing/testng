package com.xzj.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.xzj.entity.CaseData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CaseMapper extends BaseMapper<CaseData> {

    @Select("select * from api_test_data_demo ${ew.customSqlSegment}")
//    @ResultMap("BaseResultMap")
    @ResultMap("mybatis-plus_CaseData")
    List<CaseData> getCaseListByParam(@Param(Constants.WRAPPER) LambdaQueryWrapper<CaseData> caseDataQueryWrapper);

//    当用例执行过后将字段is_run更新为1
//    暂时用不到这个方法了
    @Update("update api_test_data_demo set is_run = 1 ${ew.customSqlSegment}")
    Boolean updateCaseRunState(@Param(Constants.WRAPPER) LambdaQueryWrapper<CaseData> caseDataLambdaQueryWrapper);

}
