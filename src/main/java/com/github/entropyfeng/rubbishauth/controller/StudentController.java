package com.github.entropyfeng.rubbishauth.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.begauth.config.anno.DeleteAuth;
import com.github.entropyfeng.begauth.data.vo.Message;
import com.github.entropyfeng.rubbishauth.domain.po.Student;
import com.github.entropyfeng.rubbishauth.domain.vo.StudentView;
import com.github.entropyfeng.rubbishauth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author entropyfeng
 * @date 2019/6/20 20:48
 */
@CrossOrigin
@RestController
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("/allStudent")
    String getAllStudent() {

        List<Student> studentList = studentService.getAllStudent();
        Message message = new Message();
        if (studentList != null) {
            message.setSuccess(true);
            message.addParams("studentList", JSON.toJSONString(studentList));
            message.addParams("studentNum", studentList.size() + "");
        } else {
            message.setSuccess(false);
        }

        return JSON.toJSONString(message);
    }

    @GetMapping("/student/{studentId}")
    String getStudent(@PathVariable("studentId")String studentId) {

       StudentView studentView= studentService.getStudent(studentId) ;
        Message message = new Message();
        if (studentView!= null) {
            message.setSuccess(true);
            message.addParams("student",JSON.toJSONString(studentView));
        } else {
            message.setSuccess(false);
        }

        return JSON.toJSONString(message);
    }
    @PostMapping("/student")
    String addStudent(@RequestParam("studentId")String studentId,@RequestParam("studentName")String studentName,@RequestParam("studentClass")String studentClass) {

        Message message = new Message();
        if (studentService.addStudent(studentId, studentName, studentClass)) {
            message.setSuccess(true);
        } else {
            message.setSuccess(false);
        }

        return JSON.toJSONString(message);
    }
    @DeleteMapping("/student/{studentId}")
    String deleteStudent(@PathVariable("studentId")String studentId) {

        Message message = new Message();
        if (studentService.deleteStudent(studentId)) {
            message.setSuccess(true);
        } else {
            message.setSuccess(false);
        }

        return JSON.toJSONString(message);
    }

    @PutMapping("/studentGrade/{studentId}/{studentCourse}/{studentGrade}")
    String modifyGrade(@PathVariable("studentId") String studentId,@PathVariable("studentCourse") String studentCourse,@PathVariable("studentGrade") String studentGrade){


        try {
            studentCourse=URLDecoder.decode(studentCourse,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(studentCourse);
        Message message=new Message();
        if(studentService.modifyGrade(studentId,studentCourse,studentGrade)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }


    @PostMapping("/studentGrade/{studentId}/{studentCourse}/{studentGrade}")
    String addGrade(@PathVariable("studentId") String studentId,@PathVariable("studentCourse") String studentCourse,@PathVariable("studentGrade") String studentGrade){


        try {
            studentCourse=URLDecoder.decode(studentCourse,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Message message=new Message();
        if(studentService.addGrade(studentId,studentCourse,studentGrade)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }
    @DeleteMapping("/studentGrade/{studentId}/{studentCourse}")
    String deleteGrade(@PathVariable("studentId") String studentId,@PathVariable("studentCourse") String studentCourse){


        try {
            studentCourse=URLDecoder.decode(studentCourse,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Message message=new Message();
        if(studentService.deleteGrade(studentId,studentCourse)){
            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }
}
