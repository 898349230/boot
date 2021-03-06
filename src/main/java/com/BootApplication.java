package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.ab.mapper")
@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		/**
		 * Springboot整合Elasticsearch starter 在项目启动前设置一下的属性，防止报错
		 * 解决netty冲突后初始化client时还会抛出异常
		 * java.lang.IllegalStateException: availableProcessors is already set to [8], rejecting [8]
		 */
//		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(BootApplication.class, args);
	}
}
