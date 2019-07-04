package com.github.entropyfeng.manage.domain.po;





import com.github.entropyfeng.simpleauth.data.po.BaseAuthRole;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author entropyfeng
 * 默认验证角色类
 */
public class AuthRole {




    @NotNull
    private String roleName;

    private String roleDesc;
    @NotNull
    private Integer roleId;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;

    private String roleStatus;

    //get and setter

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }


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
