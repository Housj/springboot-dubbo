package com.sergei.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.sergei.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import java.util.List;


/**
 * @author sergei
 * @create 2020-03-17
 */
@Mapper
//@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    User findByUser(long id);

//    @Update({"update user u set u.email=#{email} where u.id=#{id}"})
//    @Result(javaType =Integer.class)
//    @CacheEvict(cacheNames = "User",key = "com.com.sergei.mapper.UserMapper")
    int updateUser(@Param("email")String email,@Param("id")Long id);

    @Delete({"delete from user where id = #{id}"})
    @CacheEvict(cacheNames = "User",key = "com.com.sergei.mapper.UserMapper")
    int delete(Long id);

    User selectOne(@Param("userName")String userName,@Param("passWord")String passWord);

    User selectByUserName(@Param("userName")String userName);

    int insertUser(User user);
}
