package com.github.entropyfeng.manage.domain.po;


import com.github.entropyfeng.begauth.data.po.BaseAuthResource;

/**
 * @author entropyfeng
 * 默认验证资源类
 * 用户可自定义 验证资源类并继承{@link BaseAuthResource}
 */
public class DefaultAuthResource extends BaseAuthResource {


    private String resourceDesc;

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

}
