package com.service.Imp;

import com.dao.UserMapper;
import com.domain.User;
import com.service.UserService;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**

 *  Service layer : UserServcie Implementation class

 * @author andre

 * @Time 2018/10/29

 *

 */
@Service
public class UserServcieImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    //add log
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * Get all the Userinfo
     * @return List<User>
     */
    @Override
    public List<User> getUser() {
        logger.trace("getUser");
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setStringSerializer(redisSerializer);


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

    /**
     * update User
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int updateUser(User user) {
        logger.trace("updateUser");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * get User by id
     * @param id
     * @return
     */
    @Override
    public User getUserByid(Integer id) {
        logger.trace("getUserByid");
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * get User by username and password
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUserByUserNameAndPwd(String username, String password) {
        logger.trace("getUserByUserNameAndPwd");
        return userMapper.selectByUsernameAndPwd(username,password);
    }
}
