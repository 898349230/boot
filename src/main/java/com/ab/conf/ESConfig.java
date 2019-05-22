package com.ab.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableConfigurationProperties(ESRestClientProperties.class)
public class ESConfig {

    private static final Logger logger = LoggerFactory.getLogger(ESConfig.class);

//    es版本问题  RestHighLevelClient 暂不支持
//    @Bean
//    public RestHighLevelClient restHighLevelClient(){
//        logger.info(" ESConfig restHighLevelClient start");
//        RestClientBuilder builder = RestClient.builder(new HttpHost("aliyun.com", 9200, "http"));
//        RestHighLevelClient client = new RestHighLevelClient(builder);
//        logger.info(" ESConfig restHighLevelClient end");
//        return client;
//    }

    @Bean
    public RestClient restClient(ESRestClientProperties properties){
        logger.info(" ESConfig restClient start");
        RestClientBuilder builder = RestClient.builder(new HttpHost(properties.getHostname(), properties.getPort(), properties.getSchema()));
        RestClient build = builder.build();
        logger.info(" ESConfig restClient end");
        return build;
    }
}



