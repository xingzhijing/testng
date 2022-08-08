package com.xzj.cases;

import com.alibaba.fastjson.JSONObject;
import com.xzj.ServletInitializer;
import com.xzj.config.TestConfig;
import com.xzj.utils.HttpUtils;
import com.xzj.utils.IntegrationUtils;
import com.xzj.utils.TestEnvProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static com.xzj.dto.InterfaceName.*;

@Component
@SpringBootTest(classes = ServletInitializer.class)
public class LoginTest extends AbstractTestNGSpringContextTests{

    @Autowired
    TestEnvProperties testEnvProperties;

    @Autowired
    IntegrationUtils integrationUtils;

    private static String _xsrf;
    private static Map<String, String> headers = new HashMap<>();

    @BeforeClass
    public void beforeClass() throws IOException{
//        地址url
        String loginUrl = testEnvProperties.getUrl() + testEnvProperties.getLogin();
        Map<String, String> resultMap = HttpUtils.doGetToSid(loginUrl);
        _xsrf = resultMap.get("_xsrf");
        String sid = resultMap.get("sid");

//        账户密码登录
        String loginInterface = testEnvProperties.getUrl() + testEnvProperties.getLoginInterface();
        String username = testEnvProperties.getUserName();
        String password = testEnvProperties.getPassword();
//        获取auth
        String authorization = HttpUtils.doPostToCookies(loginInterface, username, password);
        String cookies = "";
        if (!_xsrf.isEmpty() && !sid.isEmpty() && !authorization.isEmpty()) {
            cookies = "_xsrf=" + _xsrf + "; " + "sid=" + sid + "; " + authorization;
            headers.put("cookie", cookies);
        }
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36");
    }


    @Test(description = "homepage接口")
    public void testApi() throws IOException {
        String homepage = integrationUtils.integrationUrl(HOMEPAGE);
        Map<String, String> params = new HashMap<>();
        params.put("_xsrf", _xsrf);
        JSONObject jsonObject = HttpUtils.doPost(homepage, headers, params);
        System.out.println(jsonObject);
    }

//    @BeforeTest(groups = "loginTrue", description = "登录成功")
//    public void beforeTest(){
//        TestConfig.addUserUrl = UserProperties.getInterfaceUrl(ADDUSER);
//        TestConfig.deleteUserUrl = UserProperties.getInterfaceUrl(DELETEUSER);
//        TestConfig.updateUserInfoUrl = UserProperties.getInterfaceUrl(UPDATEUSERINFO);
//        TestConfig.getUserInfoUrl = UserProperties.getInterfaceUrl(GETUSERINFO);
//    }

}
