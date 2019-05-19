package com.hushunjian.springcloud.client.user.service;

import com.hushunjian.springcloud.client.user.domain.User;

public interface UserService {
    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    User findById(String id);
}
