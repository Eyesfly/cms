package com.eyesfly.service;

import com.eyesfly.entity.User;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface IUserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsername(String username);
}
