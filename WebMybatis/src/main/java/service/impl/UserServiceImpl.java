package service.impl;


import dao.UserInfoMapper;
import domain.UserInfo;
import domain.UserInfoExample;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(UserInfo userInfo) {
        SqlSession session = MybatisUtil.getSession();
        UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
        userInfoMapper.insert(userInfo);
        session.commit();


    }

    @Override
    public int deleteUserByUsername(String userName) {

        SqlSession sqlSession = MybatisUtil.getSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        int num = userInfoMapper.deleteByUsername(userName);
        sqlSession.commit();
        return num;
    }

    @Override
    public void updateUser(UserInfo userInfo) {

        SqlSession sqlSession = MybatisUtil.getSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.updateByPrimaryKey(userInfo);
        sqlSession.commit();
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        return userInfoMapper.selectByUsername(username);

    }

    @Override
    public List<UserInfo> getUsersByParams(Integer ageBegin, Integer ageEnd, Integer sex) {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andAgeBetween(ageBegin, ageEnd).andSexEqualTo(sex);
        return userInfoMapper.selectByExample(userInfoExample);
    }


}
