package com.swu.leosanqing;

import com.swu.leosanqing.config.MainConfig;
import com.swu.leosanqing.pojo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        // 获取配置文件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        // 获取 bean文件
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
    }
}

