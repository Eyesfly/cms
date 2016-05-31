package com.eyesfly.service.impl;

import com.eyesfly.entity.Role;
import com.eyesfly.mapper.RoleMapper;
import com.eyesfly.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
@Service("roleService")
public class RoleService implements IRoleService{
@Autowired
private RoleMapper roleMapper;
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    public List<String> findRoles(String username) {
        return roleMapper.findRoles(username);
    }
}
