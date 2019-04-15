package com.leosanqing.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ComponentScan(useDefaultFilters = false)
public class Person {
    private String name;
    private int age;
}
