package com.github.entropyfeng.manage.service.impl;

import com.github.entropyfeng.manage.dao.CourseMapper;
import com.github.entropyfeng.manage.dao.GradeMapper;
import com.github.entropyfeng.manage.dao.StudentMapper;
import com.github.entropyfeng.manage.domain.po.*;
import com.github.entropyfeng.manage.domain.vo.StudentView;
import com.github.entropyfeng.manage.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author entropyfeng
 * @date 2019/6/20 20:51
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentMapper studentMapper;

    private CourseMapper courseMapper;

    private GradeMapper gradeMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, CourseMapper courseMapper, GradeMapper gradeMapper) {
        this.studentMapper = studentMapper;
        this.courseMapper = courseMapper;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public List<Student> getAllStudent() {
        StudentExample studentExample = new StudentExample();
        studentExample.clear();
        List<Student> students = studentMapper.selectByExample(studentExample);
        students.forEach(student -> {
        });
        return students;
    }

    @Override
    public List<Student> searchStudent(String studentId, String studentName) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (studentId != null && !"".equals(studentId)) {
            criteria.andStudentIdEqualTo(studentId);
        }
        if (studentName != null && !"".equals(studentName)) {
            criteria.andStudentNameEqualTo(studentName);
        }
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students != null) {
            students.forEach(student -> {
                List<Map<String, Object>> list = studentMapper.selectStudentGrade(student.getStudentId());

                double grade=0;
                for (Map<String, Object> aList : list) {
                    grade += (Double) aList.get("grade");
                }
                student.setStudentGrade(grade);
            });
        }
        return students;
    }

    @Override
    public boolean addStudent(String studentId, String studentName, String studentClass) {
        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setStudentClassName(studentClass);
        return studentMapper.insert(student) == 1;
    }

    @Override
    public boolean deleteStudent(String studentId) {

        GradeExample gradeExample = new GradeExample();
        gradeExample.createCriteria().andStudentIdEqualTo(studentId);
        gradeMapper.deleteByExample(gradeExample);
        return studentMapper.deleteByPrimaryKey(studentId) == 1;
    }

    @Override
    public StudentView getStudent(String studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        StudentView studentView = new StudentView(student);
        List<Map<String, Object>> list = studentMapper.selectStudentGrade(studentId);
        list.forEach(stringObjectMap -> {
            studentView.addCourseAndGrade((String) stringObjectMap.get("course_name"), (Double) stringObjectMap.get("grade"));
        });
        return studentView;
    }

    @Override
    public boolean modifyGrade(String studentId, String studentCourse, String studentGrade) {


        Double grade = null;
        try {
            grade = Double.parseDouble(studentGrade);
        } catch (Exception e) {
            logger.info("parse string {} error", studentGrade);
        }
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (grade != null && student != null) {
            CourseExample courseExample = new CourseExample();
            courseExample.createCriteria().andCourseNameEqualTo(studentCourse);
            List<Course> courses = courseMapper.selectByExample(courseExample);

            if (courses.size() == 1) {
                Course course = courses.get(0);
                if (course != null) {

                    int res = gradeMapper.updateGrade(studentId, course.getCourseId(), grade);
                    return res == 1;
                }


            }
        }

        return false;
    }

    @Override
    public boolean addGrade(String studentId, String studentCourse, String studentGrade) {

        Double grade = null;
        try {
            grade = Double.parseDouble(studentGrade);
        } catch (Exception e) {
            logger.info("parse string {} error", studentGrade);
        }
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (grade != null && student != null) {
            CourseExample courseExample = new CourseExample();
            courseExample.createCriteria().andCourseNameEqualTo(studentCourse);
            List<Course> courses = courseMapper.selectByExample(courseExample);

            if (courses.size() == 1) {
                Course course = courses.get(0);
                if (course != null) {

                    Grade grade1 = new Grade();
                    grade1.setGrade(grade);
                    grade1.setStudentId(studentId);
                    grade1.setCourseId(course.getCourseId());
                    return 1 == gradeMapper.insert(grade1);
                }
            }


        }
        return false;
    }

    @Override
    public boolean deleteGrade(String studentId, String studentCourse) {


        Integer courseId = getCourseId(studentCourse);

        if (courseId != null) {
            return 1 == gradeMapper.deleteGrade(studentId, courseId);
        }
        return false;
    }

    @Override
    public List<String> getAllCourse() {
        return courseMapper.getCourseNames();
    }

    @Override
    public List<String> getNotSelectCourse(String studentId) {

        List<String> contains = courseMapper.getStudentContainCourseNames(studentId);
        ;
        List<String> all = courseMapper.getCourseNames();

        //lambda 求差集
        return all.stream().filter(item -> !contains.contains(item)).collect(Collectors.toList());

    }

    private Integer getCourseId(String courseName) {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCourseNameEqualTo(courseName);
        List<Course> courseList = courseMapper.selectByExample(courseExample);

        if (courseList != null && courseList.size() == 1) {
            return courseList.get(0).getCourseId();
        }
        return null;

    }
}
