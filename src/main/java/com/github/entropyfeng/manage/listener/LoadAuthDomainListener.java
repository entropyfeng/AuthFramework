package com.github.entropyfeng.manage.listener;

import com.github.entropyfeng.begauth.config.AuthProperties;
import com.github.entropyfeng.begauth.data.to.RoleAndResource;
import com.github.entropyfeng.begauth.event.LoadAuthDomainEvent;
import com.github.entropyfeng.manage.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author entropyfeng
 * @date 2019/6/15 19:40
 */
@Component
public class LoadAuthDomainListener {

    private static final Logger logger = LoggerFactory.getLogger(LoadAuthDomainListener.class);

    @Autowired
    public LoadAuthDomainListener(AccountService accountService, StringRedisTemplate redisTemplate) {
        this.accountService = accountService;
        this.redisTemplate = redisTemplate;
    }

    private AccountService accountService;

    private StringRedisTemplate redisTemplate;

    @EventListener
    public void load(LoadAuthDomainEvent event) {
        logger.info("before load role and resources");

        List<RoleAndResource> roleAndResources = accountService.loadRolesAndResources();

        roleAndResources.forEach(roleAndResource -> {
            ArrayList<String> arrayList = roleAndResource.getResourceAndMethods().stream().collect(ArrayList::new, (objects, resourceAndMethod) -> {
                objects.add(resourceAndMethod.getResource() +AuthProperties.resourceMethodJoint+ resourceAndMethod.getMethod());
            }, List::addAll);

            String[] perms = new String[arrayList.size()];
            arrayList.toArray(perms);
            redisTemplate.opsForSet().add(AuthProperties.authRoleSuffix + roleAndResource.getRoleName(), perms);
        });


        logger.info("after load role and resources ");
    }
}
