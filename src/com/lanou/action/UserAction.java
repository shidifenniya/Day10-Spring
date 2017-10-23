package com.lanou.action;

import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Controller: action层的注解
 * Scope: action层中的对象定义需要声明为每次自动创建
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /* 登录 */
    public String Login(){

        if(userService.login("爱莉","123")){

            return "success";

        } else {

            return "error";

        }

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
