package com.sergei.server;



import com.baomidou.mybatisplus.extension.service.IService;
import com.sergei.entity.Permission;

import java.util.Set;

/**
 * @author sergei
 * @create 2019-08-08
 */
public interface PermissionService extends IService<Permission> {

    Set<String> findPermissionByUserId(Long uId);
}
