package com.github.entropyfeng.rubbishauth.dao;

import com.github.entropyfeng.rubbishauth.domain.po.Grade;
import com.github.entropyfeng.rubbishauth.domain.po.GradeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface GradeMapper {
    int countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Integer gradeId);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    int updateGrade(@Param("studentId") String studentId,@Param("courseId") Integer courseId,@Param("grade") Double grade);

   }