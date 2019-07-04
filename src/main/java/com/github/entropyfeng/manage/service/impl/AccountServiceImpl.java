package com.github.entropyfeng.manage.service.impl;

import com.github.entropyfeng.manage.dao.AuthResourceMapper;
import com.github.entropyfeng.manage.dao.AuthRoleMapper;
import com.github.entropyfeng.manage.dao.AuthUserMapper;
import com.github.entropyfeng.manage.domain.po.AuthUser;
import com.github.entropyfeng.manage.service.AccountService;
import com.github.entropyfeng.simpleauth.data.to.RoleAndResource;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;
import com.github.entropyfeng.simpleauth.service.AuthService;
import com.github.entropyfeng.simpleauth.util.SnowFlakeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public AccountServiceImpl(@SuppressWarnings("all") AuthService authService, AuthUserMapper authUserMapper, AuthRoleMapper authRoleMapper, AuthResourceMapper authResourceMapper) {
        this.authUserMapper = authUserMapper;
        this.authRoleMapper = authRoleMapper;
        this.authResourceMapper = authResourceMapper;
        this.authService = authService;

    }

    private AuthUserMapper authUserMapper;
    private AuthRoleMapper authRoleMapper;
    private AuthResourceMapper authResourceMapper;
    private AuthService authService;


    @Override
    public ArrayList<RoleAndResource> loadRolesAndResources() {

        List<Map<String, Object>> mapList = authResourceMapper.selectRolesAndResources();

        Map<String, RoleAndResource> res = new HashMap<>(10);

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
                res.put(roleName, roleAndResource);
            }
        });
        return new ArrayList<>(res.values());
    }

    @Override
    public String loginByUsername(String username, String password) throws PasswordErrorException, AccountNotExistException {

        Long userId = authUserMapper.selectUidByUsername(username);

        if (userId != null) {
            return authService.login(userId, password);
        }
        return null;
    }

    @Override
    public boolean registerByUsername(String username, String password) {

        AuthUser authUser = new AuthUser();
        authUser.setUserId(SnowFlakeUtil.getInstance().nextId());
        authUser.setPassword(password);
        authUser.setUsername(username);

        return  1==authUserMapper.insert(authUser);
    }


}
