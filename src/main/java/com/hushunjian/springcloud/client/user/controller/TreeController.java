package com.hushunjian.springcloud.client.user.controller;

import com.hushunjian.springcloud.client.user.configuration.request.tree.AddChildrenReq;
import com.hushunjian.springcloud.client.user.domain.Tree;
import com.hushunjian.springcloud.client.user.response.TreeResponse;
import com.hushunjian.springcloud.client.user.service.TreeService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hushunjian.springcloud.client.user.copier.TreeCopier.TREE_COPIER;

@Validated
@RequestMapping("tree")
@RestController(value = "tree")
public class TreeController extends BaseController {

    @Autowired
    private TreeService treeService;

    @ApiOperation("添加子集")
    @PostMapping("addChildren")
    public Object addChildren(@Validated @RequestBody AddChildrenReq req){
        Tree parent = treeService.findById(req.getParentId());
        if (parent == null){
            return filure();
        }
        treeService.addChildren(req.getNames(), parent);
        return success();
    }

    @GetMapping("addRoot")
    @ApiOperation("添加根节点")
    public Object addRoot(@NotEmpty @RequestParam String name){
        boolean exist = treeService.findByName(name);
        if (exist){
            return filure();
        }
        treeService.addRoot(name);
        return success();
    }

    @GetMapping("findParentMaxOrderNumNode")
    @ApiOperation("获取父级下最大的order_num节点")
    public Object findParentMaxOrderNumNode(@RequestParam(required = false) String parentId){
        Tree tree = treeService.findParentMaxOrderNumNode(parentId);
        return success(tree);
    }

    @GetMapping("findAll")
    @ApiOperation("获取所有的树节点")
    public Object findAll(){
        List<Tree> trees = treeService.findAll();
        List<TreeResponse> response = TREE_COPIER.toTreeResponses(trees);
        appendOutLineNum(response);
        return success(response);
    }

    private void appendOutLineNum(List<TreeResponse> treeResponses){
        Map<String, TreeResponse> collect = treeResponses.stream().collect(Collectors.toMap(TreeResponse::getId, tree -> tree));
        // 按照层级排序，层级相同的按照序号排序，保证父子集的先后顺序
        treeResponses.sort(Comparator.comparing(TreeResponse::getLevel).thenComparing(TreeResponse::getOrderNum));
        // 循环集合设置outLineNum字段
        treeResponses.forEach(response -> {
            String parentId = response.getParentId();
            if (StringUtils.isBlank(parentId)){
                response.setOutLineNum(response.getOrderNum() + "");
            } else {
                TreeResponse parent = collect.get(parentId);
                response.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(), response.getOrderNum()));

            }
        });
    }
}
