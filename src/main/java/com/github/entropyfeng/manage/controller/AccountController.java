package com.github.entropyfeng.manage.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.manage.service.AccountService;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;
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
    public String loginByUsername(@RequestParam("username") String username,@RequestParam("password") String password){

        logger.info("user {} request username login",username);

        String res= null;
        Message message=new Message();
        try {
            res = accountService.loginByUsername(username,password);
        } catch (PasswordErrorException | AccountNotExistException e) {
            e.printStackTrace();
            message.setMsg("password error or account not exist");
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
    @PostMapping("/account/register")
    public String accountRegister(@RequestParam("username")String username,@RequestParam("password")String password){

        Message message=new Message();

        if(accountService.registerByUsername(username,password)){

            message.setSuccess(true);
        }else {
            message.setSuccess(false);
        }
        return JSON.toJSONString(message);
    }

}
