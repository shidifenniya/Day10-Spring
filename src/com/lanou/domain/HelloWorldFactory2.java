package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class HelloWorldFactory2 {

    public HelloWorldFactory2() {

        System.out.println("实例工厂类的默认无参构造方法");

    }
    /* 示例工厂返回 返回某个对象 */
    public HelloWorld getInstance(){

        return new HelloWorld();

    }
}
