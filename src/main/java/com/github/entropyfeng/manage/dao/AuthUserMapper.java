package com.github.entropyfeng.manage.dao;

import com.github.entropyfeng.manage.domain.po.AuthUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper {


    int insert(AuthUser authUser);

    Long selectUidByPhone(String phone);

    Long selectUidByEmail(String email);

    Long selectUidByUsername(String username);
    AuthUser selectAuthUserByUserId(Long userId);

    AuthUser selectAuthUserByUsername(String username);

    AuthUser selectAuthUserByPhone(String phone);


    AuthUser selectAuthUserByEmail(String email);




}
