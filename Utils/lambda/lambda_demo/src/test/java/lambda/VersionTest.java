package lambda;

import com.alibaba.fastjson.JSON;
import com.leosanqing.Student;
import com.leosanqing.predicate.AgePredicate;
import com.leosanqing.predicate.StudentPredicate;
import com.leosanqing.predicate.TeacherPredicate;
import com.leosanqing.service.StudentService;
import org.junit.Test;

import java.util.List;

/**
 * @Author: leosanqing
 * @Date: 2020/1/17 上午8:20
 * @Package: lambda
 * @Description: 版本测试
 */

public class VersionTest {


    /**
     * 第一版
     *
     * 根据性别查找
     */
    @Test
    public void getFemaleStudent(){
        final List<Student> studentList = StudentService.getStudentList();

        final List<Student> femaleStudents = StudentService.getFemaleStudent(studentList);

        System.out.println(JSON.toJSONString(femaleStudents,true));

    }


    /**
     * 第二版 根据输入性别查找
     */
    @Test
    public void getStudentBySex(){
        final List<Student> studentList = StudentService.getStudentList();

        final List<Student> femaleStudents = StudentService.getStudentBySex(studentList,"男");

        System.out.println(JSON.toJSONString(femaleStudents,true));

    }

    /**
     * 版本三： 根据两个参数判断查找
     */
    @Test
    public void getStudentByAgeOrTeacher(){
        final List<Student> studentList = StudentService.getStudentList();

        final List<Student> studentByAgeOrTeacher = StudentService.getStudentByAgeOrTeacher(studentList, 20, null, true);
        System.out.println(JSON.toJSONString(studentByAgeOrTeacher,true));


    }

    /**
     *  版本四，使用接口，策略者模式
     */
    @Test
    public void filterStudent(){
        final List<Student> studentList = StudentService.getStudentList();

        final TeacherPredicate teacherPredicate = new TeacherPredicate();

        final List<Student> students = StudentService.filterStudent(studentList,teacherPredicate);
        System.out.println(JSON.toJSONString(students,true));

    }


    /**
     * 版本五，使用匿名内部类
     */
    @Test
    public void AnonymousInnerClass(){
        final List<Student> studentList = StudentService.getStudentList();
        final List<Student> students = StudentService.filterStudent(studentList, new StudentPredicate() {
            @Override
            public boolean filter(Student student) {
                return "如来".equals(student.getTeacher());
            }
        });
        System.out.println(JSON.toJSONString(students,true));

    }


    /**
     * 版本五，使用lambda
     */
    @Test
    public void lambda(){
        final List<Student> studentList = StudentService.getStudentList();
        final List<Student> students = StudentService.filterStudent(studentList, student -> "如来".equals(student.getTeacher()));
        System.out.println(JSON.toJSONString(students,true));

    }

}
