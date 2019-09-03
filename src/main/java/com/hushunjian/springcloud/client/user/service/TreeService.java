package com.hushunjian.springcloud.client.user.service;

import com.hushunjian.springcloud.client.user.domain.Tree;

import java.util.List;

public interface TreeService {

    Tree findById(String id);

    boolean findByName(String name);

    void addRoot(String name);

    Tree findParentMaxOrderNumNode(String parentId);

    void addChildren(List<String> names, Tree parent);

    List<Tree> findAll();
}
