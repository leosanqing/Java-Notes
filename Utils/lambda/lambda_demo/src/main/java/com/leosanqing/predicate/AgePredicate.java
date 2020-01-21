package com.leosanqing.predicate;

import com.leosanqing.Student;

/**
 * @Author: leosanqing
 * @Date: 2020/1/19 下午11:49
 * @Package: com.leosanqing.predicate
 * @Description: 根据年龄过滤
 */
public class AgePredicate implements StudentPredicate {
    @Override
    public boolean filter(Student student) {
        return student.getAge() > 20;
    }
}
