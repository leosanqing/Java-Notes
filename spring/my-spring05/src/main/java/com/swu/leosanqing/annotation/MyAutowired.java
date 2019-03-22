package com.swu.leosanqing.annotation;

import java.lang.annotation.*;


// 定义在哪里使用，Field 表示只能在成员变量中使用
@Target(ElementType.FIELD)
// 定义什么时候启动，表示运行中启动
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
    String value() default "";
}
