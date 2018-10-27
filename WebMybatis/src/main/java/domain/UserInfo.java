package domain;

import java.util.Date;

public class UserInfo {

    private Integer id;


    private String userName;


    private Integer age;


    private Integer sex;


    private Date createDate;


    public UserInfo(Integer id, String userName, Integer age, Integer sex, Date createDate) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.createDate = createDate;
    }


    public UserInfo() {
        super();
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}