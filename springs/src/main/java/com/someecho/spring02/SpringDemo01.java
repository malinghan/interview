package com.someecho.spring02;

import com.someecho.aop.ISchool;
import com.someecho.spring01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo01 {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student123 = context.getBean(Student.class);

        Student student123 = (Student) context.getBean("student123");
        System.out.println(student123.toString());
        
        Student student100 = (Student) context.getBean("student100");
        System.out.println(student100.toString());
        //io.kimmking.spring02.Klass$$EnhancerBySpringCGLIB$$d1e01abe(对象-集合)
        Klass class1 = context.getBean(Klass.class);
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型："+class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(class1 instanceof Klass));
    
        ISchool school = context.getBean(ISchool.class);
        //com.sun.proxy.$Proxy13 接口
        System.out.println(school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school.getClass());
        
        ISchool school1 = context.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school1.getClass());
        
        school1.ding();
        
        class1.dong();
    
        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));
        

    }
}
