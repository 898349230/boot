package com.ab.mapper;

import com.ab.bean.Employee;
import org.apache.ibatis.annotations.Select;

//@Mapper 或者 @MapperScan 将接口扫描装配到容器中
//@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getById(String id);

}
