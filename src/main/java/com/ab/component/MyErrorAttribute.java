package com.ab.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义 errorAttribute
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
//        加入自定义返回json数据
        map.put("zidingyi", "aaaaaaaaaaaa");
//        异常处理器携带的数据
        Map<String, Object> m = (Map<String, Object>)webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        map.put("ext", m);
        return map;
    }
}
