package com.github.entropyfeng.manage.service;



import com.github.entropyfeng.simpleauth.data.to.RoleAndResource;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;

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


    public String loginByUsername(String username,String password)throws PasswordErrorException,AccountNotExistException;

    public boolean registerByUsername(String username,String password);
}
