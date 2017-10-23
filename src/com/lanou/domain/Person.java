package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class Person {

    public Person() {
        System.out.println("Person无参构造方法");
    }

    public void init(){

        System.out.println("init");

    }

    public void destroy(){

        System.out.println("destroy");

    }

    public void test(){
        System.out.println("test");
    }
}
