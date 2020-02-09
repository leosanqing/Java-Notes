package com.leosanqing.service;

import com.leosanqing.Student;
import com.leosanqing.predicate.StudentPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leosanqing
 * @Date: 2020/1/17 上午7:58
 * @Package: com.leosanqing.service
 * @Description: 学生服务类
 */
public class StudentService {
    private static List<Student> studentList = new ArrayList<Student>() {
        {
            add(new Student("张三丰", 20, "男", "体育",
                    180, 75, "太上老君"));
            add(new Student("张无忌", 18, "男", "语文",
                    178, 73, "文曲星"));
            add(new Student("赵敏", 17, "女", "数学",
                    170, 50, "太白金星"));
            add(new Student("金毛狮王", 25, "男", "体育",
                    176, 80, "太白金星"));
            add(new Student("周芷若", 16, "女", "语文",
                    168, 48, "太上老君"));
            add(new Student("张三", 21, "男", "英语",
                    172, 65, "如来"));
            add(new Student("赵勇", 26, "男", "体育",
                    188, 80, "太上老君"));


        }
    };


    public static List<Student> getStudentList() {
        return studentList;
    }

    /**
     * 版本一
     * 找出女学生
     *
     * @return
     */
    public static List<Student> getFemaleStudent(List<Student> studentList) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if ("女".equals(student.getSex())) {
                students.add(student);
            }
        }
        return students;
    }

    /**
     * 版本二
     * <p>
     * 根据输入性别查找学生
     *
     * @param studentList
     * @param sex
     * @return
     */
    public static List<Student> getStudentBySex(List<Student> studentList, String sex) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (sex.equals(student.getSex())) {
                students.add(student);
            }
        }
        return students;
    }

    /**
     * 版本三
     * <p>
     * 根据输入的年龄或者老师查找。true表示使用年龄，false表示使用老师这个参数
     *
     * @param studentList
     * @param age
     * @return
     */
    public static List<Student> getStudentByAgeOrTeacher(List<Student> studentList, int age,
                                                         String teacher, boolean ageOrTeacher) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if ((ageOrTeacher && student.getAge() > age)
                    || !ageOrTeacher && teacher.equals(student.getTeacher())
                ) {

                students.add(student);
            }
        }
        return students;
    }


    /**
     * 版本四
     *
     * 使用多态完成，使用策略者模式
     * @param studentList
     * @param predicate
     * @return
     */
    public static List<Student> filterStudent(List<Student> studentList, StudentPredicate predicate) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if(predicate.filter(student)){
                students.add(student);
            }
        }
        return students;
    }



}
