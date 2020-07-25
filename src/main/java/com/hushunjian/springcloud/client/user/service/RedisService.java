package com.hushunjian.springcloud.client.user.service;

public interface RedisService {


    boolean hasKey(String key);


    void set(String key, Object value);


    Object get(String key);
}
