package com.xzj.base;

import org.springframework.web.util.HtmlUtils;
public class Test1 {
    public static void main(String[] args) {
        String sourceStr = "&gt;&nbsp;&lt;";
        System.out.println("原始 sourceStr = " +  sourceStr);

        //将转义后的html解析成原本的值
        String targetStr = HtmlUtils.htmlUnescape(sourceStr);
        System.out.println("目标 targetStr = " + targetStr );
    }

}

