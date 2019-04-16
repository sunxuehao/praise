package cn.sun.test;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/10
 * \
 */
public class RedisTest extends  BaseJunit4Test {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","sunxuehao123");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
