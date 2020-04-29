package com.sergei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sergei.entity.UserRole;


public interface UserRoleMapper extends BaseMapper<UserRole> {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}