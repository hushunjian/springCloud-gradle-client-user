package com.hushunjian.springcloud.client.user.controller;


import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.response.UserResponse;
import com.hushunjian.springcloud.client.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.hushunjian.springcloud.client.user.copier.UserCopier.USER_COPIER;

@RequestMapping("user")
@RestController(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户信息")
    @GetMapping(value = "findById")
    @ApiImplicitParam(value = "订单主键ID", name = "id", paramType = "query")
    public Object findById(@RequestParam String id){
        User user = userService.findById(id);
        UserResponse userResponse = USER_COPIER.toUserResponse(user);
        return success(userResponse);
    }
}
