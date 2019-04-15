package com.leosanqing;

import com.leosanqing.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoApp = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("还没有取person");
        Object person1 = annoApp.getBean("person");
        Object person2 = annoApp.getBean("person");
        System.out.println(person1 == person2);
    }
}
