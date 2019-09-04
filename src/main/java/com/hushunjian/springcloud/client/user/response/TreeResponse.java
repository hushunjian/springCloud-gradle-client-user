package com.hushunjian.springcloud.client.user.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TreeResponse {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "节点名称")
    private String name;

    @ApiModelProperty(value = "父级ID")
    private String parentId;

    @ApiModelProperty(value = "父级全名称")
    private String parentFullName;

    @ApiModelProperty(value = "父级全ID")
    private String parentFullId;

    @ApiModelProperty(value = "序号")
    private Integer orderNum;

    @ApiModelProperty(value = "层级编号")
    private String path;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "展示序号")
    private String outLineNum;

    public String getParentId(){
        if (parentId == null){
            return "";
        }
        return parentId;
    }

    public String getParentOutLineNum(){
        if (outLineNum.contains(".")){
            return outLineNum.substring(0, outLineNum.lastIndexOf("."));
        }
        return "";
    }
}
