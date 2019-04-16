package cn.sun.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/6
 * \
 */
@Aspect
@Component
public class LogInterceptor {
    @Before(value = "execution(* cn.sun.controller.*.*(..))")
    public void before(){
        System.out.println("进入方法时间为：" + System.currentTimeMillis());
    }

    @After(value = "execution(* cn.sun.controller.*.*(..))")
    public void after(){
        System.out.println("退出方法时间为：" + System.currentTimeMillis());
    }
}
