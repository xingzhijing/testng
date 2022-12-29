package com.xzj.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class Validation {
    /**
     * code码验证
     * */
    public static boolean ValidationResultForCode(String code){
        try {
            Assert.assertEquals(code, "0");
            return true;
        }catch (AssertionError assertionError){
            System.out.println(assertionError);
            return false;
        }
    }

    /**
     * msg验证
     * */
    public static boolean ValidationResultForMsg(String msg){
//        验证msg
        try {
            Assert.assertEquals(msg, "成功");
            return true;
        }catch (AssertionError assertionError){
            System.out.println(assertionError);
            return false;
        }
    }

    /**
     * data验证
     * */
    public static boolean ValidationResultForData(Object data){
//        验证msg
        try {
            Assert.assertNotNull(data, "data是空值");
            return true;
        } catch (AssertionError assertionError){
            System.out.println(assertionError);
            return false;
        }
    }

    /**
     * 验证code和msg
     * */
    public static String flag = "";
    public static boolean ValidationResultForCodeAndMsg(String code, String msg){
        try {
            Assert.assertEquals(code, "0");
            flag = "code通过";
            Assert.assertEquals(msg, "成功");
            flag = "code 和 msg 通过";
            return true;
        } catch (AssertionError assertionError){
            System.out.println(assertionError);
            return false;
        } finally {
            System.out.println(flag);
        }
    }

    /**
     *
     * */
    public static boolean ValidationResultForAll(String code, String msg, Object data){
        try {
            Assert.assertEquals(code, "0");
            flag = "code通过";
            Assert.assertEquals(msg, "成功");
            flag = "code 和 msg 通过";
            Assert.assertNotNull(data, "data是空值");
            flag = "code 和 msg 和 data 都通过";
            return true;
        } catch (AssertionError assertionError){
            System.out.println(assertionError);
            return false;
        } finally {
            System.out.println(flag);
        }
    }

//    public static Result ValidationResult(JSONObject jsonObject){
//        if (jsonObject.get("code").equals("0") || jsonObject.get("code").equals(0)){
//            return Result.succeed("data", jsonObject.get("data"));
//        }else {
//            return Result.fail(String.valueOf(jsonObject.get("code")), (String) jsonObject.get("msg"));
//        }
//    }

    public static void main(String[] args) {
        String str = "{"
                + "\"success\" : false,"
                + "\"code\" : 0,"
//                + "\"msg\" : \"信息已存在，请勿重复提交\","
                + "\"msg\" : \"成功\","
                + "\"data\" : null,"
                + "}";
//        String s = {"success":false; "code":"-1", "msg"="信息已存在，请勿重复提交", data=null};
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(ValidationResultForCodeAndMsg(String.valueOf(jsonObject.get("code")), (String) jsonObject.get("msg")));
//        System.out.println(ValidationResultForAll(String.valueOf(jsonObject.get("code")), (String) jsonObject.get("msg"), jsonObject.get("data")));
//        System.out.println(ValidationResultForCode((String) jsonObject.get("data")));
    }

}
