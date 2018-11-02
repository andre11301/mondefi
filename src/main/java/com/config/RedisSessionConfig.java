package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**

 *  Share Session via redis

 * @author andre

 * @Time 2018/11/02

 *

 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    
}




