package com.sergei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sergei.entity.Permission;
import com.sergei.mapper.PermissionMapper;
import com.sergei.server.PermissionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * @author sergei
 * @create 2019-08-08
 */
@Service
@Component
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public Set<String> findPermissionByUserId(Long uId) {
        return baseMapper.findPermissionByUserId(uId);
    }

    @Override
    public boolean saveBatch(Collection<Permission> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Permission> entityList) {
        return false;
    }

    @Override
    public boolean update(Wrapper<Permission> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Permission> entityList) {
        return false;
    }

    @Override
    public Permission getOne(Wrapper<Permission> queryWrapper) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Permission> list() {
        return null;
    }

    @Override
    public IPage<Permission> page(IPage<Permission> page) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return null;
    }

    @Override
    public List<Object> listObjs() {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<Permission> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Permission> page) {
        return null;
    }

    @Override
    public QueryChainWrapper<Permission> query() {
        return null;
    }

    @Override
    public LambdaQueryChainWrapper<Permission> lambdaQuery() {
        return null;
    }

    @Override
    public UpdateChainWrapper<Permission> update() {
        return null;
    }

    @Override
    public LambdaUpdateChainWrapper<Permission> lambdaUpdate() {
        return null;
    }
}
