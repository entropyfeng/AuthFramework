package com.github.entropyfeng.manage.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.begauth.config.anno.GetAuth;
import com.github.entropyfeng.begauth.data.vo.Message;
import com.github.entropyfeng.manage.exception.PasswordErrorException;
import com.github.entropyfeng.manage.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author entropyfeng
 * @date 2019/6/18 22:30
 */
@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    private static final Logger logger =LoggerFactory.getLogger(AccountController.class);

    @PostMapping("/account/login")
    public String login(@RequestParam("user_id") String userId,@RequestParam("password") String password){

        logger.info("user {} request login",userId);

        String res= null;
        Message message=new Message();
        try {
            res = accountService.loginByUserId(userId,password);
        } catch (PasswordErrorException e) {
            e.printStackTrace();
            message.setMsg("password error");
            message.setSuccess(false);

            return JSON.toJSONString(message);
        }

        if(res!=null){

            message.setMsg("login success");
            message.setSuccess(true);
            message.addParams("auth_token",res);
        }else {
            message.setMsg("login error unknown");
            message.setSuccess(false);

        }

        return JSON.toJSONString(message);
    }


    @GetAuth("/account")
    @GetMapping("/account")
    public String getAccount(){

        return "account get";
    }
}
