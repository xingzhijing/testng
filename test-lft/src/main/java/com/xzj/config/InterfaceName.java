package com.xzj.config;

public enum InterfaceName {
//    司机
    DRIVER_CREATE("添加司机"),
    DRIVER_DELETE("删除司机"),
    DRIVER_UPDATE("修改司机"),
    DRIVER_SELECT("查询司机"),
//    载具
    CAR_CREATE("添加载具"),
    CAR_DELETE("删除载具"),
    CAR_UPDATE("修改载具"),
    CAR_SELECT("查询载具"),
//    运单
    ORDER_CREATE("添加运单"),
    ORDER_DELETE("删除运单"),
    ORDER_UPDATE("修改运单"),
    ORDER_SELECT("查询运单");

    private final String desc;

    InterfaceName(String desc) {
        this.desc = desc;
    }

}
