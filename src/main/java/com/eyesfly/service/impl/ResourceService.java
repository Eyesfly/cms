package com.eyesfly.service.impl;

import com.eyesfly.entity.Resource;
import com.eyesfly.mapper.ResourceMapper;
import com.eyesfly.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
@Service("resourceService")
public class ResourceService implements IResourceService{
@Autowired
private ResourceMapper resourceMapper;
    public int deleteByPrimaryKey(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    public int insertSelective(Resource record) {
        return resourceMapper.insertSelective(record);
    }

    public Resource selectByPrimaryKey(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Resource record) {
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }

    public List<String> findPermissions(String username) {
        return resourceMapper.findPermissions(username);
    }
}
