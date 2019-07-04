package com.github.entropyfeng.manage.dao;

import com.github.entropyfeng.manage.domain.po.AuthRole;
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
    int insert(AuthRole record);




    /**
     * 根据roleId 查询
     * @param roleId 角色id
     * @return role
     */
    AuthRole selectByPrimaryKey(Integer roleId);



    List<String> selectContainRoles(Long userId);


}