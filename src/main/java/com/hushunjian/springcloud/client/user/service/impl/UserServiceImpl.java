package com.hushunjian.springcloud.client.user.service.impl;

import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.mapper.UserMapper;
import com.hushunjian.springcloud.client.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
