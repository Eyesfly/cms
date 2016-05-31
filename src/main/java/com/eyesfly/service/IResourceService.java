package com.eyesfly.service;

import com.eyesfly.entity.Resource;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface IResourceService {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<String> findPermissions(String username);
}
