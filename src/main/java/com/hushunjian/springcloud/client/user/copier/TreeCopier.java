package com.hushunjian.springcloud.client.user.copier;

import com.hushunjian.springcloud.client.user.domain.Tree;
import com.hushunjian.springcloud.client.user.response.TreeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TreeCopier {
    TreeCopier TREE_COPIER = Mappers.getMapper(TreeCopier.class);

    Tree toTree(String id, String name, String parentId, String parentFullName, String parentFullId, Integer orderNum, String path, Integer level);

    TreeResponse toTreeResponse(Tree tree);

    List<TreeResponse> toTreeResponses(List<Tree> trees);

}
