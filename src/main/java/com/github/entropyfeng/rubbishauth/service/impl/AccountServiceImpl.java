package com.github.entropyfeng.rubbishauth.service.impl;

import com.github.entropyfeng.begauth.data.po.BaseAuthUser;
import com.github.entropyfeng.begauth.data.to.RoleAndResource;
import com.github.entropyfeng.rubbishauth.dao.AuthResourceMapper;
import com.github.entropyfeng.rubbishauth.dao.AuthRoleMapper;
import com.github.entropyfeng.rubbishauth.dao.AuthUserMapper;
import com.github.entropyfeng.rubbishauth.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author entropyfeng
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    public AccountServiceImpl(AuthUserMapper authUserMapper, AuthRoleMapper authRoleMapper, AuthResourceMapper authResourceMapper) {
        this.authUserMapper = authUserMapper;
        this.authRoleMapper = authRoleMapper;
        this.authResourceMapper = authResourceMapper;
    }

    private AuthUserMapper authUserMapper;
    private AuthRoleMapper authRoleMapper;
    private AuthResourceMapper authResourceMapper;


    @Override
    public ArrayList<RoleAndResource> loadRolesAndResources() {

        List<Map<String, Object>> mapList = authResourceMapper.selectRolesAndResources();

        Map<String, RoleAndResource> res = new HashMap<>();

        mapList.forEach(stringObjectMap -> {
            String roleName = (String) stringObjectMap.get("role_name");
            String resourceContent = (String) stringObjectMap.get("resource_content");
            String resourceType = (String) stringObjectMap.get("resource_type");
            if (res.containsKey(roleName)) {
                res.get(roleName).addEntity(resourceContent, resourceType);
            } else {

                RoleAndResource roleAndResource = new RoleAndResource();
                roleAndResource.addEntity(resourceContent, resourceType);
                roleAndResource.setRoleName(roleName);
                res.put(roleName,roleAndResource);
            }
        });
        return new ArrayList<>(res.values());
    }

    @Override
    public String loginByUserId(@NotNull String userId, @NotNull String password) {


       BaseAuthUser authUser= authUserMapper.selectAuthUserByUserId(userId);
       if(authUser.getPassword().equals(password) ){

       }
        return null;
    }
}
