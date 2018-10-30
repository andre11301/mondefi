package com.service.Imp;

import com.dao.UserMapper;
import com.domain.User;
import com.service.UserService;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServcieImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<User> getUser() {

        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setStringSerializer(redisSerializer);
        //高并发,双重锁
        List<User> list= (List<User>) redisTemplate.opsForValue().get("allUser");
        if(null == list){
            synchronized (this){
                list= (List<User>) redisTemplate.opsForValue().get("allUser");
                if(null== list){
                    list = userMapper.selectAllUser();
                    redisTemplate.opsForValue().set("allUser",list);
                }
            }
        }
        return list ;
    }

    @Override
    @Transactional
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserByid(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }
}
