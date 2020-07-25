package com.hushunjian.springcloud.client.user.controller;


import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.enumeration.SexEnum;
import com.hushunjian.springcloud.client.user.request.user.AddUserReq;
import com.hushunjian.springcloud.client.user.response.UserResponse;
import com.hushunjian.springcloud.client.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.hushunjian.springcloud.client.user.copier.UserCopier.USER_COPIER;

@RequestMapping("user")
@RestController(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户信息")
    @GetMapping(value = "findById")
    @ApiImplicitParam(value = "用户主键ID", name = "id", paramType = "query")
    public Object findById(@RequestParam String id){
        User user = userService.findById(id);
        UserResponse userResponse = USER_COPIER.toUserResponse(user);
        userResponse.setSex(SexEnum.MAN);
        return userResponse;
    }

    @ApiOperation("添加用户")
    @PostMapping(value = "addUser")
    public Object addUser(@RequestBody AddUserReq req) {
        return success(req.getSex());
    }
}
