package com.xzj.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzj.ServletInitializer;
import com.xzj.utils.HttpUtils;
import com.xzj.utils.IntegrationUtils;
import com.xzj.utils.properties.TestEnvProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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


    @Test(description = "homepage接口", enabled = false)
    public void testApi() throws IOException {
        String homepage = integrationUtils.integrationUrl(HOMEPAGE);
        Map<String, String> params = new HashMap<>();
        params.put("_xsrf", _xsrf);
        JSONObject jsonObject = HttpUtils.doPost(homepage, headers, params);
        System.out.println(jsonObject);
    }

    @DataProvider(name = "ids_key")
    public Object[][] testEtcCard() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("_xsrf", _xsrf);
        params.put("select_all", "1");
        JSONObject jsonObject = HttpUtils.doPost(integrationUtils.integrationUrl(ETC_CARD), headers, params);
        System.out.println(jsonObject);
        return new Object[][]{{jsonObject}};
    }

    @Test(dataProvider = "ids_key", description = "etc卡管理列表导出")
    public void testExportCard(JSONObject response) throws IOException {
//        拿到接口返回的ids_key
        String idsKey = response.getJSONObject("data").getString("ids_key");
        System.out.println("ids_key: " + idsKey);
//        开始调接口
        Map<String, String> exportParamsMap = new HashMap<>();
        exportParamsMap.put("_xsrf", _xsrf);
        exportParamsMap.put("ids_key", idsKey);
        JSONObject result = HttpUtils.doPost(integrationUtils.integrationUrl(ETC_CARD_EXPORT), headers, exportParamsMap);
        System.out.println(result);
    }





//    @BeforeTest(groups = "loginTrue", description = "登录成功")
//    public void beforeTest(){
//        TestConfig.addUserUrl = UserProperties.getInterfaceUrl(ADDUSER);
//        TestConfig.deleteUserUrl = UserProperties.getInterfaceUrl(DELETEUSER);
//        TestConfig.updateUserInfoUrl = UserProperties.getInterfaceUrl(UPDATEUSERINFO);
//        TestConfig.getUserInfoUrl = UserProperties.getInterfaceUrl(GETUSERINFO);
//    }

}
