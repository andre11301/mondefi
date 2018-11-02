package com.service.Imp;

import com.dao.ProductDetailMapper;
import com.domain.ProductDetail;
import com.domain.User;
import com.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
/**

 *  Service layer : ProductDetailService Implementation class

 * @author andre

 * @Time 2018/10/29

 *

 */
@Service
public class ProductDetailServiceImp implements ProductDetailService {

    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * getting all the product infos
     * @return List<ProductDetail>
     */
    @Override
    public List<ProductDetail> getAllProduct() {

        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setStringSerializer(redisSerializer);


        List<ProductDetail> list= (List<ProductDetail>) redisTemplate.opsForValue().get("allProduct");
        if(null == list){
            synchronized (this){
                list= (List<ProductDetail>) redisTemplate.opsForValue().get("allProduct");
                if(null== list){
                    list = productDetailMapper.selectAllProduct();
                    redisTemplate.opsForValue().set("allProduct",list);
                }
            }
        }
        return list ;
    }
}
