package com.github.entropyfeng.manage.domain.po;


import com.github.entropyfeng.begauth.data.po.BaseAuthUser;

/**
 * @author entropyfeng
 * 默认验证用户类
 * 用户可以自定义验证类并继承{@link BaseAuthUser}
 */
public class DefaultAuthUser extends BaseAuthUser {

    public DefaultAuthUser(){
        super();
    }


    private String username;

    private String email;

    private String phone;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
