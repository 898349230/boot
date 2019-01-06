package com.ab.controller;

import com.ab.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {

    /**
     * 自定义捕获到的异常处理器
     * 页面客客户端都返回json数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("error", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    /**
     * 转发到 error 自适应
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();

        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("error", "user.notexist");
//        map.put("code", "cccccode");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
//        转发到error
        return "forward:/error";
    }
}
