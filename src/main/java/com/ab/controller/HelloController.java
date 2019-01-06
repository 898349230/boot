package com.ab.controller;

import com.ab.bean.Department;
import com.ab.bean.Employee;
import com.ab.bean.Person;
import com.ab.bean.Person2;
import com.ab.exception.UserNotExistException;
import com.ab.mapper.DepartmentMapper;
import com.ab.mapper.EmployeeMapper;
import com.ab.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private Person person;
    @Autowired
    private Person2 person2;
    @Autowired
    private HelloService helloService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayHello(@RequestParam(value = "aa", required = false)String aa){
//        System.out.println(person);
//        System.out.println(person2);
        if("aa".equals(aa)){
            throw new UserNotExistException();
        }
        logger.info("~~~~~~~~~~~~~~~~~~~ controller info ");
        logger.debug("~~~~~~~~~~~~~~~~~~~ controller debug");
        helloService.hello();

        return "hello word!";
    }

    @RequestMapping(value = "/success")
    public String hello(Map<String, String> map){
        logger.info("~~~~~~~~~~~~~~~~~~~ test index.html ");
        map.put("hello", "你好啊");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/employee/{id}")
    public Employee getEmployee(@PathVariable(value = "id") String id){
        Employee employee = employeeMapper.getById(id);
        return employee;
    }

    @ResponseBody
    @RequestMapping(value = "/dept/{id}")
    public Department getDept(@PathVariable(value = "id") String id){
        Department department = departmentMapper.getDepartmentById(id);
        return department;
    }

}
