package com.leosanqing.config;

import com.leosanqing.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan
@Controller
@Service
public class Config {
    @Bean
    @Lazy
    @Conditional(LinuxCondition.class)
    //@Scope("prototype")
    public Person person(){
        System.out.println("已经加载person");
        return new Person("leosanqing",22);
    }
}
