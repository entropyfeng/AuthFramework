package com.github.entropyfeng.rubbishauth.dao;

import com.github.entropyfeng.rubbishauth.domain.po.DefaultAuthResource;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 资源访问DAO
 * @author entropyfeng
 */
@Mapper
public interface AuthResourceMapper {


    /**
     * 根据主键删除资源
     * @param resourceId 资源
     * @return 受影响行数
     */
    int deleteByPrimaryKey(Integer resourceId);

    /**
     * 插入资源
     * @param record 资源
     * @return 受影响行数
     */
    int insert(DefaultAuthResource record);


    /**
     * 查询资源
     * @param resourceId 资源id
     * @return 受影响行数
     */
    DefaultAuthResource selectByPrimaryKey(Integer resourceId);


    @MapKey("role_name")
    List<Map<String, Object>> selectRolesAndResources();

}