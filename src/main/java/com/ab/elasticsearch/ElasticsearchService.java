package com.ab.elasticsearch;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticsearchService {

//    @Autowired
//    private PersonRespository personRespository;
    @Autowired
    private RestClient restClient;

//    es版本问题  RestHighLevelClient 暂不支持
//    @Autowired
//    private RestHighLevelClient restHighLevelClient;

    public Integer addPerson(){

        Request request = new Request("post", "/sxb/emp/");
        request.addParameter("pretty", "true");
        request.setEntity(new NStringEntity("{\"name\":\"zs\",\"age\":25}", ContentType.APPLICATION_JSON));
        try {
            Response response = restClient.performRequest(request);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String getPerson(){
        Request request = new Request("get", "/sxb01/doc/1");
        try {
            Response response = restClient.performRequest(request);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
