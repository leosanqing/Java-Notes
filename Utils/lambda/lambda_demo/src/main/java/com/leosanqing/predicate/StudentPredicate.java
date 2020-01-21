package com.leosanqing.predicate;

import com.leosanqing.Student;

/**
 * @Author: leosanqing
 * @Date: 2020/1/19 下午11:41
 * @Package: com.leosanqing.service
 * @Description: 学生条件接口
 */
public interface StudentPredicate {
    boolean filter(Student student);
}
