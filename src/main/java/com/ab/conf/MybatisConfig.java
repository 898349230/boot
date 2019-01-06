package com.ab.conf;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

//@Configuration    已使用配置文件形式 设置 驼峰原则
public class MybatisConfig {

//    @Bean  已使用配置文件形式 设置 驼峰原则
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
//               设置驼峰命名法
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };

    }
}
