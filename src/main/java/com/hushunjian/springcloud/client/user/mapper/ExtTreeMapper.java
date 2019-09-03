package com.hushunjian.springcloud.client.user.mapper;

import com.hushunjian.springcloud.client.user.domain.Tree;

import java.util.List;

public interface ExtTreeMapper {

    void insertBatch(List<Tree> trees);
}
