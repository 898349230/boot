package com.ab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(value = "username", required = false)String username,
                        @RequestParam(value = "password", required = false)String password,
                        Map<String, String> map,
                        HttpSession session){
        logger.info("~~~~~~~~~~~~~~~~~~~ login ");

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            map.put("msg", "请输入用户名或者密码");
            return "login";
        }
        session.setAttribute("loginUser", "zhangsan");
//        登陆成功 防止表单重复提交 重定向
        return "redirect:/main.html";

    }
}
