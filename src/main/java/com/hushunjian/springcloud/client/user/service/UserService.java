package com.hushunjian.springcloud.client.user.service;

import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.request.user.AddUserReq;

public interface UserService {
    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 用户登录
     *
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName, String password);

    /**
     * 添加用户
     *
     * @param req
     * @return
     */
    String addUser(AddUserReq req);
}
