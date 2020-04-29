package com.sergei.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sergei.entity.User;
import com.sergei.mapper.UserMapper;
import com.sergei.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author sergei
 * @create 2020-03-17
 */
@Service
@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int add(User user) {
        user.setRegTime(new Date());
        int u = userMapper.insertUser(user);
        return u;
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> findPage(int pageNum, int pageSize) {
        Page page =  PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //MybatisPlus的EntityWrapper 在3.0版本以上就没发现了，改为了QueryWrapper
//        wrapper.like("user_name","name");
        return userMapper.selectList(wrapper);
    }

    @Override
    public User findByUser(long id) {
        return userMapper.findByUser(id);
    }

    @Override
    public User findByUser(String userName,String passWord){
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_name",userName);
//        wrapper.eq("pass_word",passWord);
//        wrapper.excludeColumns("user_address");
        return userMapper.selectOne(userName,passWord);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user.getEmail(),user.getId());
    }

    @Override
    public int delete(Long id) {
        userMapper.delete(new QueryWrapper<User>().eq("id",id));
        return 1;
    }

    @Override
    public User selectByUserName(String userName){
        return userMapper.selectByUserName(userName);
    }
}
