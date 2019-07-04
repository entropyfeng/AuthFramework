package com.github.entropyfeng.manage.domain.po;


import com.github.entropyfeng.simpleauth.data.po.BaseAuthUser;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author entropyfeng
 * 默认验证用户类
 * 用户可以自定义验证类并继承{@link BaseAuthUser}
 */
public class AuthUser {


    @NotNull
    private Long userId;

    @NotNull
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    private String userStatus;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;

    private String username;

    private String email;

    private String phone;



    //get and setter begin


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }



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
