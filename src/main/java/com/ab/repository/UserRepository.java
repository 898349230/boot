package com.ab.repository;

import com.ab.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
//                                                   实体类  主键类型
public interface UserRepository extends JpaRepository<User, String>{
}
