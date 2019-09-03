package com.hushunjian.springcloud.client.user.service.impl;

import com.hushunjian.springcloud.client.user.domain.Tree;
import com.hushunjian.springcloud.client.user.domain.TreeExample;
import com.hushunjian.springcloud.client.user.mapper.ExtTreeMapper;
import com.hushunjian.springcloud.client.user.mapper.TreeMapper;
import com.hushunjian.springcloud.client.user.service.TreeService;
import com.hushunjian.springcloud.client.user.util.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.hushunjian.springcloud.client.user.copier.TreeCopier.TREE_COPIER;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Autowired
    private ExtTreeMapper extTreeMapper;

    @Override
    public Tree findById(String id) {
        return treeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean findByName(String name) {
        TreeExample example = new TreeExample();
        TreeExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return !treeMapper.selectByExample(example).isEmpty();
    }

    @Override
    public void addRoot(String name) {
        Tree record = new Tree();
        record.setName(name);
        record.setLevel(1);
        // 找出parent为null的最大的
        Integer orderNum = getNextOrderNum(null);
        record.setOrderNum(orderNum);
        String path = String.format("%04d", orderNum);
        record.setPath(path);
        record.setId(IdUtils.generateId());
        treeMapper.insertSelective(record);
    }

    @Override
    public Tree findParentMaxOrderNumNode(String parentId) {
        TreeExample example = new TreeExample();
        TreeExample.Criteria criteria = example.createCriteria();
        if (parentId == null){
            criteria.andParentIdIsNull();
        } else {
            criteria.andParentIdEqualTo(parentId);
        }
        example.setOrderByClause("order_num desc limit 1");
        List<Tree> trees = treeMapper.selectByExample(example);
        if (trees.isEmpty()){
            return null;
        }
        return trees.get(0);
    }

    private Integer getNextOrderNum(String parentId){
        Tree parentMaxOrderNumNode = findParentMaxOrderNumNode(parentId);
        Integer orderNum = 1;
        if (parentMaxOrderNumNode != null){
            orderNum = parentMaxOrderNumNode.getOrderNum() + 1;
        }
        return orderNum;
    }

    @Override
    public void addChildren(List<String> names, Tree parent) {
        Integer orderNum = getNextOrderNum(parent.getId());
        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Integer  nodeOrderNum = orderNum + i;
            trees.add(TREE_COPIER.toTree(IdUtils.generateId(), names.get(i), parent.getId(), appendParentFullName(parent), appendParentFullId(parent), nodeOrderNum, String.format("%s.%04d", parent.getPath(), nodeOrderNum), parent.getLevel() + 1));
        }
        extTreeMapper.insertBatch(trees);
    }

    private String appendParentFullName(Tree parent){
        if (StringUtils.isBlank(parent.getParentFullName())){
            return parent.getName();
        }
        return String.format("%s-%s", parent.getParentFullName(), parent.getName());
    }

    private String appendParentFullId(Tree parent){
        if (StringUtils.isBlank(parent.getParentFullId())){
            return parent.getId();
        }
        return String.format("%s-%s", parent.getParentFullId(), parent.getId());
    }

    @Override
    public List<Tree> findAll() {
        TreeExample example = new TreeExample();
        return treeMapper.selectByExample(example);
    }
}
