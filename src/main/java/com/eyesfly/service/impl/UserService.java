package com.eyesfly.service.impl;

import com.eyesfly.entity.User;
import com.eyesfly.mapper.UserMapper;
import com.eyesfly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/5/31.
 */
@Service("userService")
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;


    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
