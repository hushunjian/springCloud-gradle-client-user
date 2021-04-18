package com.hushunjian.springcloud.client.user.service.impl;

import com.hushunjian.springcloud.client.user.domain.User;
import com.hushunjian.springcloud.client.user.domain.UserExample;
import com.hushunjian.springcloud.client.user.mapper.UserMapper;
import com.hushunjian.springcloud.client.user.request.user.AddUserReq;
import com.hushunjian.springcloud.client.user.service.UserService;
import com.hushunjian.springcloud.client.user.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.hushunjian.springcloud.client.user.copier.UserCopier.USER_COPIER;

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

    @Override
    public User login(String loginName, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(loginName).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public String addUser(AddUserReq req) {
        User user = USER_COPIER.toUser(req, IdUtils.generateId());
        userMapper.insert(user);
        return user.getId();
    }
}
