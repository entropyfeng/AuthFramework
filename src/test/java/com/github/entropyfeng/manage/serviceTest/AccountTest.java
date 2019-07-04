package com.github.entropyfeng.manage.serviceTest;

import com.github.entropyfeng.manage.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author entropyfeng
 * @date 2019/7/4 20:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountTest {


    @Autowired
    AccountService accountService;

    @Test
    public void testRegister(){

        for (int i=0;i<=10;i++){
           String s= "user"+String.valueOf(i);
            accountService.registerByUsername(s,s);
        }

    }

}
