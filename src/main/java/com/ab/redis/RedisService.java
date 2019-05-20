package com.ab.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public String getString(String key){

        ValueOperations ops = redisTemplate.opsForValue();
        return (String) ops.get(key);
    }

    public void setString(String key, String value){

        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }
}
