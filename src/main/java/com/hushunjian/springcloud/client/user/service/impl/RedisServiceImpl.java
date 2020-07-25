package com.hushunjian.springcloud.client.user.service.impl;

import com.hushunjian.springcloud.client.user.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public boolean hasKey(String key) {
        Boolean exist = redisTemplate.hasKey(key);
        return exist == null ? false : exist;
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }


    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
