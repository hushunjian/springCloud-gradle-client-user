package com.hushunjian.springcloud.client.user.response;

import com.hushunjian.springcloud.client.user.enumeration.SexEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResponse {

    @ApiModelProperty(value = "用户主键ID")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "手机号码")
    private String mobilePhone;

    @ApiModelProperty(value = "固定电话")
    private String telephoneNumber;

    @ApiModelProperty(value = "现居住地")
    private String address;

    @ApiModelProperty(value = "性别(1:男性;2:女性)")
    private SexEnum sex;
}
