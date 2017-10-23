package com.lanou.dao.impl;

import com.lanou.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Repository: dao层注解, 如果不指定括号中的字符串,会给当前Bean一个默认id(userDaoImpl);
 *             括号中的字符串是给当前bean设置一个特定的id名称(推荐)
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String name, String psw) {

        if(name.equals("爱莉") && psw.equals("123")){

            return true;

        }

        return false;
    }
}
