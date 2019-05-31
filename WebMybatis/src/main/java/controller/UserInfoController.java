package controller;

import domain.UserInfo;
import service.impl.UserServiceImpl;

import java.util.Date;
import java.util.List;

public class UserInfoController {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

/*        for (int i=0;i<10;i++){
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName("admin"+String.valueOf(i));
            userInfo.setAge(i%3);
            long time=System.currentTimeMillis();
            Date date=new Date(time);
            userInfo.setSex(i%2);
            userInfo.setCreateDate(date);
            userService.addUser(userInfo);
        }*/

/*List<UserInfo> userInfos= userService.getUsersByParams(0,1,0);

        for (UserInfo userInfo:userInfos) {
            System.out.println(userInfo.getUserName());
        }*/

        UserInfo userInfo = userService.getUserByUsername("admin9");
        userInfo.setUserName("admin99");
        userService.updateUser(userInfo);
    }
}
