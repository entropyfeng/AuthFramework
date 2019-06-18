package com.github.entropyfeng.rubbishauth.dao;

import com.github.entropyfeng.rubbishauth.domain.po.DefaultAuthRole;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * @author entropyfeng 角色DAO
 */
@Mapper
public interface AuthRoleMapper {


    /**
     * 根据roleId 删除AuthRole
     * @param roleId 角色id
     * @return 受影响的数量
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * 插入新角色
     * @param record 角色
     * @return 影响数据
     */
    int insert(DefaultAuthRole record);




    /**
     * 根据roleId 查询
     * @param roleId 角色id
     * @return role
     */
    DefaultAuthRole selectByPrimaryKey(Integer roleId);


    List selectContainRoles(Integer userId);


}