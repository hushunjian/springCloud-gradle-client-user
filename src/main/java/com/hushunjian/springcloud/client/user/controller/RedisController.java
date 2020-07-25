package com.hushunjian.springcloud.client.user.controller;


import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.service.RedisService;
import com.hushunjian.springcloud.client.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequestMapping("redis")
@RestController(value = "redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @ApiOperation("判断redis key是否存在")
    @GetMapping(value = "hasKey")
    @ApiImplicitParam(value = "redis key", name = "key", paramType = "query")
    public boolean hasKey(@RequestParam String key){
        return redisService.hasKey(key);
    }

    @ApiOperation("查询用户放到缓存里面")
    @GetMapping(value = "userToRedis")
    @ApiImplicitParam(value = "用户ID", name = "userId", paramType = "query")
    public boolean userToRedis(@RequestParam String userId) {
        User user = userService.findById(userId);
        if (user != null) {
            redisService.set(userId, user);
            return true;
        }
        return false;
    }

    @ApiOperation("从缓存中获取信息")
    @GetMapping(value = "get")
    @ApiImplicitParam(value = "用户ID", name = "userId", paramType = "query")
    public Object get(@RequestParam String userId){
        if (redisService.hasKey(userId)) {
            return redisService.get(userId);
        }
        return null;
    }

}
