package com.lanou.test;

import com.lanou.action.UserAction;
import com.lanou.dao.UserDao;
import com.lanou.dao.impl.UserDaoImpl;
import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/23.
 */
public class UserTest {

    @Test
    public void test(){

        //1. 先获得action对象

        UserAction userAction = new UserAction();

        UserServiceImpl userService = new UserServiceImpl();

        UserDao userDao = new UserDaoImpl();

        userService.setUserDao(userDao);

        userAction.setUserService(userService);

        userAction.Login();

        //2. 调用action的登录方法
        // action -> service(impl) -> dao(impl)

    }

    @Test
    public void testXMLDI(){

        //启动登录容器
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-user.xml"});

        //通过spring容器的getBean方法返回action对象
        UserAction action = (UserAction) context.getBean("userAction");

        //调用login方法
        String login = action.Login();

        System.out.println(login);

    }
    /* 利用注解的方式实现ioc (控制反转) 和 DI (依赖注入) */
    @Test
    public void testAnnotation(){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-user-annotation.xml"});

        UserAction userAction = (UserAction) context.getBean("userAction");

        //调用action中的方法
        String result = userAction.Login();

        System.out.println(result);
    }

}
