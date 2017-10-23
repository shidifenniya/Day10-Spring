package com.lanou.service;

/**
 * Created by dllo on 17/10/23.
 */
public interface UserService {

    /**
     * 登录
     * @param name 用户名
     * @param psw 密码
     */
    boolean login(String name, String psw);

}
