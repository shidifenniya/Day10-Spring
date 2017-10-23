package com.lanou.service.impl;

import com.lanou.dao.UserDao;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service: service层bean注解, 指定当前bean对应的id为userService
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * Autowired: 按照类型匹配
     * Qualifier: 按照注入的id1名称匹配, 更加精准
     * 通常两个注解一起使用
     */

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao; //dao层对象

    @Override
    public boolean login(String name, String psw) {

        //调用dao层的登录方法
        return userDao.login(name,psw);

    }

    /* userDao对象对外提供getter,setter方法 */

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
