package cn.sun.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTest springTest = (SpringTest) applicationContext.getBean("springTest");
        springTest.sayHello();
    }
    public void sayHello(){
        System.out.println("hello");
    }
}


