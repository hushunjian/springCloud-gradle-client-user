package com.hushunjian.springcloud.client.user.annotation;

import com.hushunjian.springcloud.client.user.service.RedisService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class ReqAuthFilterAspect {

    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.hushunjian.springcloud.client.user.annotation.ReqAuthFilter)")
    public void limitPoint() {

    }


}
