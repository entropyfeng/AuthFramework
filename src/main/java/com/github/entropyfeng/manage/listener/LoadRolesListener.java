package com.github.entropyfeng.manage.listener;

import com.github.entropyfeng.manage.dao.AuthRoleMapper;
import com.github.entropyfeng.simpleauth.event.LoadUserRolesEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/7/4 20:03
 */
@Component
public class LoadRolesListener {

    private final AuthRoleMapper authRoleMapper;

    @Autowired
    public LoadRolesListener(AuthRoleMapper authRoleMapper) {
        this.authRoleMapper = authRoleMapper;
    }

    @EventListener
    public void listener(LoadUserRolesEvent event){
      List<String> roles=  authRoleMapper.selectContainRoles(event.getUserId());
      event.addRoles(new HashSet<>(roles));
    }
}
