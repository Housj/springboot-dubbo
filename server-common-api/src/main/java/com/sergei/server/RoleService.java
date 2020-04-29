package com.sergei.server;



import com.baomidou.mybatisplus.extension.service.IService;
import com.sergei.entity.Role;

import java.util.Set;

/**
 * @author sergei
 * @create 2019-08-08
 */
public interface RoleService extends IService<Role> {
    Set<String> findRoleByUserId(Long id);
}
