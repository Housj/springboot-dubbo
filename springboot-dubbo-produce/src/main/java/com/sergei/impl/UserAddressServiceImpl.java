package com.sergei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
//import org.redisson.Redisson;
//import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//@Service
//@Component
//@Transactional
//@Slf4j
public class UserAddressServiceImpl{

//    @Autowired
//    private UserAddressMapper userAddressMapper;
//
//    private String lock = "testLock";
//
//    @Autowired
//    private Redisson redisson;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @HystrixCommand
//    @Override
//    public List<UserAddress> findByUser(Long id) {
//        log.info("UserAddressServiceImpl.findByUser."+id);
//        return userAddressMapper.findByUser(id);
//    }
//
//    @Override
//    public PageInfo<UserAddress> findPageByUserId(int pageNum,int PageSize) {
//        return null;
//    }
//
//    @Override
//    public int jian(int id) {
//        int result = 0;
//        RLock redisLock = redisson.getLock(lock);
//        try {
//            redisLock.lock();
//            String number = (String) stringRedisTemplate.opsForValue().get("stock");
//            if ("".equals(number) || Integer.parseInt(number) > 0){
//
//                result = userAddressMapper.jian(id);
//                Long l = new Long(id);
//                List<UserAddress> lists = userAddressMapper.findByUser(l);
//                System.out.println(result!=0?"抢到了，下一个是"+lists.get(0).getNumber():"没抢到");
//                if (result==0){
//                    return result;
//                }
//                int realStock = Integer.parseInt(number) - 1;
//
//                stringRedisTemplate.opsForValue().set("stock",realStock+"");
//                System.out.println("扣减成功，剩余库存"+realStock);
//            }else {
//                System.out.println("扣减失败，库存不足");
//            }
//        } finally {
//           redisLock.unlock();
//        }
//        return result;
//    }

//    @Override
//    public int jian(int id) {
//        int result = 0;
//        //Boolean b = stringRedisTemplate.opsForValue().setIfAbsent(lock,String.valueOf(id));
//        Jedis jedis =  RedisTool.getJedis();
//
//        Boolean b = RedisTool.lock(jedis,lock,"testa",60);
//        try {
//            if (!b){
//                //Thread.sleep(1000);
//                //jian(id);
//                return result;
//            }else {
//                String number = (String) stringRedisTemplate.opsForValue().get("stock");
//                if ("".equals(number) || Integer.parseInt(number) > 0){
//
//                    result = userAddressMapper.jian(id);
//
//                    if (result==0){
//                        return result;
//                    }
//                    int realStock = Integer.parseInt(number) - 1;
//
//                    stringRedisTemplate.opsForValue().set("stock",realStock+"");
//                    System.out.println("扣减成功，剩余库存"+realStock);
//            }else {
//                System.out.println("扣减失败，库存不足");
//            }
//            }
//        } finally {
//            RedisTool.unLock(jedis,lock,"testa");
//            //stringRedisTemplate.delete(lock);
//        }
//
//        return result;
//    }

}
