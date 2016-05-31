package com.eyesfly.service;

import com.eyesfly.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface IRoleService {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<String> findRoles(String username);
}
