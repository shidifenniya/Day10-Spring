package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class HelloWorldFactory {

    public HelloWorldFactory() {

        System.out.println("静态工厂类的无参构造方法");

    }

    /* 静态工厂方法设置模式
         * 通过静态方法获取某个对象
         * */
    public static HelloWorld getInstance(){

        return new HelloWorld();

    }

}
