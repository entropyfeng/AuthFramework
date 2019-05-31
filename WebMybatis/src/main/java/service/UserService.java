package service;

import domain.UserInfo;

import java.util.List;

public interface UserService {

    void addUser(UserInfo userInfo);

    int deleteUserByUsername(String userName);

    void updateUser(UserInfo userInfo);

    UserInfo getUserByUsername(String username);

    List<UserInfo> getUsersByParams(Integer ageBegin, Integer ageEnd, Integer sex);

}
