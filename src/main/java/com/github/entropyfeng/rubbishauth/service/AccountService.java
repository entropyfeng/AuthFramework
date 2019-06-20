package com.github.entropyfeng.rubbishauth.service;



import com.github.entropyfeng.begauth.data.to.RoleAndResource;
import com.github.entropyfeng.rubbishauth.exception.PasswordErrorException;

import java.util.ArrayList;

/**
 * 账户服务
 */
public interface AccountService {


    /**
     *
     * 从数据库加载role 以及其对应的资源(状态为 ENABLE)
     * @return ArrayList {@link RoleAndResource}
     *
     */
    public ArrayList<RoleAndResource> loadRolesAndResources();

    public String loginByUserId(String userId,String password)throws PasswordErrorException;

}
