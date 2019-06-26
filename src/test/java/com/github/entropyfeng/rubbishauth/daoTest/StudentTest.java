package com.github.entropyfeng.rubbishauth.daoTest;

import com.github.entropyfeng.rubbishauth.dao.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;

/**
 * @author entropyfeng
 * @date 2019/6/23 21:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void test(){
     List list=  studentMapper.selectStudentGrade("3162052051031");

     list.get(0);
    }
}
