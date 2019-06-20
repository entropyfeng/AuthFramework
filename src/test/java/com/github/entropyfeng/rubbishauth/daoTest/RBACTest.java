package com.github.entropyfeng.rubbishauth.daoTest;

import com.github.entropyfeng.rubbishauth.dao.AuthResourceMapper;
import com.github.entropyfeng.rubbishauth.dao.AuthRoleMapper;
import com.github.entropyfeng.rubbishauth.dao.AuthUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/6/18 17:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RBACTest {

    @Autowired
    AuthUserMapper authUserMapper;

    @Autowired
    AuthRoleMapper authRoleMapper;

    @Autowired
    AuthResourceMapper authResourceMapper;

    @Test
    public void test(){

      List list=  authRoleMapper.selectContainRoles("user1111");

        list.get(0);
    }
}
