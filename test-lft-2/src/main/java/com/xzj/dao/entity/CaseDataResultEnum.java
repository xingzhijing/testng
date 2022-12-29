package com.xzj.dao.entity;

public enum CaseDataResultEnum {
    FAIL(0, "测试未通过"), PASS(1, "测试通过"), NOTRUN(3, "没有执行过");
    public final int codeValue;
    private final String chinese;

    CaseDataResultEnum(int codeValue, String chinese) {
        this.codeValue = codeValue;
        this.chinese = chinese;
    }
}
