package com.hushunjian.springcloud.client.user.request.user;

import com.hushunjian.springcloud.client.user.enumeration.SexEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class AddUserReq {

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "性别(1:男性;2:女性)")
    private SexEnum sex;

    @ApiModelProperty(value = "出生日期")
    private ZonedDateTime birthday;
}
