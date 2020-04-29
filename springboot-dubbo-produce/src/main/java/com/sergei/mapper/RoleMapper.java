package com.sergei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sergei.entity.Role;

import java.util.Set;


public interface RoleMapper extends BaseMapper<Role> {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Set<String> findRoleByUserId(Long id);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}