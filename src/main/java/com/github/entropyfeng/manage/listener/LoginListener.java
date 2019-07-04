package com.github.entropyfeng.manage.listener;

import com.github.entropyfeng.manage.dao.AuthUserMapper;
import com.github.entropyfeng.manage.domain.po.AuthUser;
import com.github.entropyfeng.simpleauth.data.status.LoginStatus;
import com.github.entropyfeng.simpleauth.event.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/7/4 19:56
 */
@Component
public class LoginListener {

    private final AuthUserMapper authUserMapper;

    @Autowired
    public LoginListener(AuthUserMapper authUserMapper) {
        this.authUserMapper = authUserMapper;
    }

    @EventListener
    public void listenerLogin(LoginEvent loginEvent){

      AuthUser authUser= authUserMapper.selectAuthUserByUserId(loginEvent.getUserId());

      if(authUser==null){
          loginEvent.setLoginStatus(LoginStatus.ACCOUNT_NOT_EXIST);
      }else if(authUser.getPassword().equals(loginEvent.getPassword())){
        loginEvent.setLoginStatus(LoginStatus.SUCCESS);
      }
    }
}
