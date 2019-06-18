package com.github.entropyfeng.rubbishauth.domain.po;




import com.github.entropyfeng.begauth.data.po.BaseAuthRole;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * 默认验证角色类
 * 用户可自定义验证角色类并继承{@link BaseAuthRole}
 */
public class DefaultAuthRole extends BaseAuthRole {


    public DefaultAuthRole(){
        super();

    }

    @NotNull
    private String roleName;

    private String roleDesc;



    //get and setter


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }


}
