package com.github.entropyfeng.manage.daoTest;

import com.github.entropyfeng.manage.dao.CourseMapper;
import com.github.entropyfeng.manage.dao.GradeMapper;
import com.github.entropyfeng.manage.dao.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

/**
 * @author entropyfeng
 * @date 2019/6/23 21:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    CourseMapper courseMapper;
    @Test
    public void test(){
     List list=  studentMapper.selectStudentGrade("3162052051031");

     list.get(0);
    }
    @Test
    public void test1(){

       List<String> strings= courseMapper.getStudentContainCourseNames("3162052051031");

       strings.forEach(System.out::println);
    }
}
