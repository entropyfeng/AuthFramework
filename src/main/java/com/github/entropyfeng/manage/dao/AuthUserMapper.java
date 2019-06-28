package com.github.entropyfeng.manage.dao;

import com.github.entropyfeng.manage.domain.po.DefaultAuthUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper {


    int insert(DefaultAuthUser authUser);

    DefaultAuthUser selectAuthUserByUserId(String userId);

    DefaultAuthUser selectAuthUserByUsername(String username);

    DefaultAuthUser selectAuthUserByPhone(String phone);


    DefaultAuthUser selectAuthUserByEmail(String email);

    String selectUidByPhone(String phone);

    String selectUidByEmail(String email);

    String selectUidByUsername(String username);


}
