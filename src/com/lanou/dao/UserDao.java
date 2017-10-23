package com.lanou.dao;

/**
 * Created by dllo on 17/10/23.
 */
public interface UserDao {

    /**
     * 登录
     * @param name 用户名
     * @param psw 密码
     */
    boolean login(String name, String psw);

}
