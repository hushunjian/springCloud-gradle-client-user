package com.hushunjian.springcloud.client.user.util;

import com.google.common.collect.Lists;
import com.hushunjian.springcloud.client.user.response.TreeResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OutLineNumUtils {

    public static void appendOutLineNum(List<TreeResponse> treeResponses){
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

    public static void pathToOutLineNum(List<TreeResponse> treeResponses){
        treeResponses.forEach(response -> {
            String[] split = response.getPath().split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                sb.append(Long.valueOf(s)).append(".");
            }
            response.setOutLineNum(sb.substring(0, sb.length() - 1));
        });
    }

    public static void generateOutLineNum(List<TreeResponse> treeResponses){
        List<TreeResponse> roots = new ArrayList<>();
        Map<String, List<TreeResponse>> parentChildrenMap = new HashMap<>();
        treeResponses.forEach(response -> {
            if (StringUtils.isBlank(response.getParentId())){
                // 没有父级的就是根节点
                roots.add(response);
            }
            parentChildrenMap.computeIfAbsent(response.getParentId(), v -> Lists.newArrayList()).add(response);
        });
        // 循环root
        for (int i = 0; i < roots.size(); i++) {
            TreeResponse root = roots.get(i);
            root.setOutLineNum((i + 1) + "");
            appendChildrenOutLineNum(root, parentChildrenMap);
        }
    }

    private static void appendChildrenOutLineNum(TreeResponse parent, Map<String, List<TreeResponse>> parentChildrenMap){
        List<TreeResponse> children = parentChildrenMap.get(parent.getId());
        if (CollectionUtils.isEmpty(children)){
            return;
        }
        children.sort(Comparator.comparing(TreeResponse::getOrderNum));
        for (int i = 0; i < children.size(); i++) {
            TreeResponse child = children.get(i);
            child.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(), i + 1));
            appendChildrenOutLineNum(child, parentChildrenMap);
        }
    }
}
