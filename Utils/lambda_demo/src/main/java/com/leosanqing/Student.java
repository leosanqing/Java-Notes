package com.leosanqing;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: leosanqing
 * @Date: 2020/1/17 上午7:54
 * @Package: com.leosanqing
 * @Description: 学生类
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String sex;
    /**
     * 课程
     */
    private String subject;
    private int height;
    private int weight;
    private String teacher;

}
