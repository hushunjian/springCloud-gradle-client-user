package com.hushunjian.springcloud.client.user.controller;

import com.hushunjian.springcloud.client.user.comparator.OutLineNumComparator;
import com.hushunjian.springcloud.client.user.request.tree.AddChildrenReq;
import com.hushunjian.springcloud.client.user.domain.Tree;
import com.hushunjian.springcloud.client.user.response.TreeResponse;
import com.hushunjian.springcloud.client.user.service.TreeService;
import com.hushunjian.springcloud.client.user.util.OutLineNumUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

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

    @GetMapping("findAllByAppend")
    @ApiOperation("获取所有的树节点")
    public Object findAllByAppend(){
        List<Tree> trees = treeService.findAll();
        List<TreeResponse> response = TREE_COPIER.toTreeResponses(trees);
        OutLineNumUtils.appendOutLineNum(response);
        response.sort(new OutLineNumComparator());
        return success(response);
    }

    @GetMapping("findAllByPath")
    @ApiOperation("获取所有的树节点")
    public Object findAllByPath(){
        List<Tree> trees = treeService.findAll();
        List<TreeResponse> response = TREE_COPIER.toTreeResponses(trees);
        OutLineNumUtils.pathToOutLineNum(response);
        response.sort(new OutLineNumComparator());
        return success(response);
    }

    @GetMapping("findAllByGenerate")
    @ApiOperation("获取所有的树节点")
    public Object findAllByGenerate(){
        List<Tree> trees = treeService.findAll();
        List<TreeResponse> response = TREE_COPIER.toTreeResponses(trees);
        OutLineNumUtils.generateOutLineNum(response);
        response.sort(new OutLineNumComparator());
        return success(response);
    }

}
