package com.sergei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sergei.entity.RolePermission;

public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}