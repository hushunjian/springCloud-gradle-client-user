package com.hushunjian.springcloud.client.user.copier;

import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.request.user.AddUserReq;
import com.hushunjian.springcloud.client.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCopier {
    UserCopier USER_COPIER = Mappers.getMapper(UserCopier.class);

    UserResponse toUserResponse(User user);

    @Mapping(target = "loginName", source = "req.name")
    @Mapping(target = "userName", source = "req.name")
    @Mapping(target = "password", defaultValue = "123456789")
    User toUser(AddUserReq req, String id);
}
