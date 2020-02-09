package com.leosanqing.predicate;

import com.leosanqing.Student;

/**
 * @Author: leosanqing
 * @Date: 2020/1/19 下午11:51
 * @Package: com.leosanqing.predicate
 * @Description: 根据老师过滤
 */
public class TeacherPredicate implements StudentPredicate{
    @Override
    public boolean filter(Student student) {
        return "如来".equals(student.getTeacher());
    }
}
