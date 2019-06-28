package com.github.entropyfeng.manage.service;

import com.github.entropyfeng.manage.domain.po.Student;
import com.github.entropyfeng.manage.domain.vo.StudentView;

import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/6/20 20:30
 */
public interface StudentService {



    List<Student> getAllStudent();

    List<Student> searchStudent(String studentId,String studentName);
    boolean addStudent(String studentId,String studentName,String studentClass);

    boolean deleteStudent(String studentId);

    StudentView getStudent(String studentId);

    boolean modifyGrade(String studentId,String studentCourse,String studentGrade);


    boolean addGrade( String studentId,String studentCourse,String studentGrade);

    boolean deleteGrade(String studentId,String studentCourse);

    List<String> getAllCourse();
    List<String> getNotSelectCourse(String studentId);

}
