package com.xzy.uncertainty.service.impl;

import com.xzy.uncertainty.dao.UserMapper;
import com.xzy.uncertainty.pojo.User;
import com.xzy.uncertainty.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private UserMapper userMapper = null;

    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
