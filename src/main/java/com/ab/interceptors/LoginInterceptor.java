package com.ab.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ preHandle ");
        logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RequestURI : " + request.getRequestURI());
        if(null == loginUser){
            logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ loginUser is null ");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("Please login!!!!!!!!!!!!!!");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ postHandle ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ afterCompletion ");
    }
}
