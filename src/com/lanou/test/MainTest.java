package com.lanou.test;

import com.lanou.domain.HelloWorld;
import com.lanou.domain.HelloWorldFactory2;
import com.lanou.domain.Person;
import com.lanou.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/23.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){

        /* 获得Spring容器对象 */
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    /* 测试最基础的IOC
     * 1.在Spring配置文件中定义的bean默认情况下会在 new ApplicationContext容器对象时
     * 调用bean默认无参构造方法创建对象,并将对象加入到Spring容器中,以供后续的getBean方法调用
     * 2. 加入Spring容器的对象默认情况下是单例模式, 即整个应用只创建一次该对象
     *
     * */
    @Test
    public void testHello(){

        /* 从容器中获得id为helloWorld的对象 */
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

        //使用sayHello
        helloWorld.sayHello();

        System.out.println("第一次调用的对象" + helloWorld.hashCode());

        HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld");

        System.out.println("第二次调用的对象" + helloWorld1.hashCode());

    }
    /* 静态工厂设计模式的测试

     */
    @Test
    public void testFactory(){

        //通过工厂类 id 获得 bean 对象
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldFactory");

        //调用bean中的方法
        helloWorld.sayHello();

    }
    /* 通过示例工厂的方法获得helloWorld对象 */
    @Test
    public void testFactory2(){

        //1.先获得实例工厂类对象获得helloWorld对象
        HelloWorldFactory2 helloWorldFactory2 = (HelloWorldFactory2) context.getBean("helloWorldFactory2");

        //2.通过示例工厂类对象获得HelloWorld对象
        HelloWorld helloWorld = helloWorldFactory2.getInstance();

        //3.调用方法
        helloWorld.sayHello();
    }

    /* 实例工厂模式获得对象的完整写法
    * 1. 实例工厂对象的创建需要在spring配置文件中先配置实例工厂类对象
    * 2. 再配置具体的bean引用, 其中factory-bean指向实例工厂类的bean中的id
    * 3. factory-method指向实例工厂类获得bean的方法,例如getInstance方法
    * 4. 在代码中就可以直接获取bean对象配置的id,不用再获得实例工厂类的对象
    * 5. 实例工厂模式会先进入工厂类的无参构造方法,然后才进入某个bean对象的构造方法,
    *   即此模式创建两个对象,而静态工厂模式的方法只会创建一个对象*/
    @Test
    public void testFactory3(){

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");

        helloWorld.sayHello();

    }

    /* 测试懒加载属性 lazy-init */
    @Test
    public void testLazy(){

        Person person = (Person) context.getBean("person");

        person.test(); //调用正常方法

        //关闭Spring容器, 触发bean中的销毁方法
        ((ClassPathXmlApplicationContext)context).close();

    }

    /* 测试依赖注入 */
    @Test
    public void testDI(){

        /* 1. 测试构造方法注入 */
        Student student = (Student) context.getBean("student");

        System.out.println(student);

        //输入引入其他对象的属性
        System.out.println(student.getPerson());

    }
}
