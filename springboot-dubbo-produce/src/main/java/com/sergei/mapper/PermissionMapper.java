package com.sergei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sergei.entity.Permission;

import java.util.Set;


public interface PermissionMapper extends BaseMapper<Permission> {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Set<String> findPermissionByUserId(Long uId);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}