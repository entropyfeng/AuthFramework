package com.github.entropyfeng.manage.dao;

import com.github.entropyfeng.manage.domain.po.AuthResource;
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
    int insert(AuthResource record);


    /**
     * 查询资源
     * @param resourceId 资源id
     * @return 受影响行数
     */
    AuthResource selectByPrimaryKey(Integer resourceId);


    @MapKey("role_name")
    List<Map<String, Object>> selectRolesAndResources();

}