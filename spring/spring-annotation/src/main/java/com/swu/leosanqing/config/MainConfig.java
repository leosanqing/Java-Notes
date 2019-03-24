package com.swu.leosanqing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.swu.leosanqing.pojo.Person;

// 这个注解是表明他是配置文件
@Configuration
public class MainConfig {

    // @Bean 注解，自动加入容器
    @Bean
    public Person person(){
        return new Person("lisi",18);
    }
}
