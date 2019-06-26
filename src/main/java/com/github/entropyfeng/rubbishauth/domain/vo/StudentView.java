package com.github.entropyfeng.rubbishauth.domain.vo;

import com.github.entropyfeng.rubbishauth.domain.po.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author entropyfeng
 * @date 2019/6/20 20:30
 * select student.student_id,student.student_name,student.student_class_name,course.course_name,grade.grade  from student  inner join grade on grade.student_id=student.student_id inner join course on grade.course_id=course.course_id
 */
public class StudentView extends Student {
    public StudentView(Student student){
        super();
        super.studentId=student.getStudentId();
        super.studentName=student.getStudentName();
        super.studentClassName=student.getStudentClassName();
    }
    private Map<String,Double> courseAndGrade=new HashMap<>();

    public Map<String, Double> getCourseAndGrade() {
        return courseAndGrade;
    }

    public void setCourseAndGrade(Map<String, Double> courseAndGrade) {
        this.courseAndGrade = courseAndGrade;
    }
    public void addCourseAndGrade(String courseName,Double grade){
        courseAndGrade.put(courseName,grade);
    }

}
