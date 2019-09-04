package com.hushunjian.springcloud.client.user.request.tree;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddChildrenReq {

    @ApiModelProperty(value = "父级id")
    private String parentId;

    @ApiModelProperty(value = "子节点名称")
    private List<String> names;
}
