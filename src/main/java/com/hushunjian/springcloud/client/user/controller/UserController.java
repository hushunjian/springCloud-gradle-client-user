package com.hushunjian.springcloud.client.user.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.enumeration.SexEnum;
import com.hushunjian.springcloud.client.user.request.user.AddUserReq;
import com.hushunjian.springcloud.client.user.response.UserResponse;
import com.hushunjian.springcloud.client.user.service.UserService;
import com.hushunjian.springcloud.client.user.system.HttpUser;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.hushunjian.springcloud.client.user.copier.UserCopier.USER_COPIER;

@RequestMapping("user")
@RestController(value = "user")
public class UserController{

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户信息")
    @GetMapping(value = "findById")
    @ApiImplicitParam(value = "用户主键ID", name = "id", paramType = "query")
    public Response<UserResponse> findById(@RequestParam String id){
        User user = userService.findById(id);
        UserResponse userResponse = USER_COPIER.toUserResponse(user);
        userResponse.setSex(SexEnum.MAN);
        return Response.success(userResponse);
    }

    @ApiOperation("添加用户")
    @PostMapping(value = "addUser")
    public Response addUser(@RequestBody AddUserReq req) {
        userService.addUser(req);
        return Response.success(req.getSex());
    }

    @ApiOperation("用户登录")
    @GetMapping(value = "login")
    public Response login(String loginName, String password, HttpServletResponse response) {
        User user = userService.login(loginName, password);
        if (user == null) {
            return Response.failure();
        }
        response.setHeader("authorization", new HttpUser(user.getId(), user.getLoginName()).toString());
        return Response.success();
    }
}
