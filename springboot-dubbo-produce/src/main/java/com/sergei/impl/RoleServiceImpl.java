package com.sergei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sergei.entity.Role;
import com.sergei.mapper.RoleMapper;
import com.sergei.server.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Set<String> findRoleByUserId(Long uId) {
        return baseMapper.findRoleByUserId(uId);
    }

    @Override
    public boolean saveBatch(Collection<Role> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Role> entityList) {
        return false;
    }

    @Override
    public boolean update(Wrapper<Role> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Role> entityList) {
        return false;
    }

    @Override
    public Role getOne(Wrapper<Role> queryWrapper) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Role> list() {
        return null;
    }

    @Override
    public IPage<Role> page(IPage<Role> page) {
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
    public List<Object> listObjs(Wrapper<Role> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Role> page) {
        return null;
    }

    @Override
    public QueryChainWrapper<Role> query() {
        return null;
    }

    @Override
    public LambdaQueryChainWrapper<Role> lambdaQuery() {
        return null;
    }

    @Override
    public UpdateChainWrapper<Role> update() {
        return null;
    }

    @Override
    public LambdaUpdateChainWrapper<Role> lambdaUpdate() {
        return null;
    }
}
