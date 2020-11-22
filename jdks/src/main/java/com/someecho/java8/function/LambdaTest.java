package com.someecho.java8.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author : linghan.ma
 * @Package com.someecho.java8.function
 * @Description:
 * @date Date : 2020年11月20日 3:55 PM
 **/
public class LambdaTest {
    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> list = Arrays.asList(person1,person2,person3);

        LambdaTest test = new LambdaTest();
        //测试第一个方法。
        List<Person> list1 = test.getPersonByUsername("zhangsan", list);
        list1.forEach(person -> System.out.println(person.getUsername()));
        //测试第二种方法
        List<Person> personByAge = test.getPersonByAge(20, list);
        personByAge.forEach(person -> System.out.println(person.getAge()));
        //测试第三方法
        List<Person> peopleList = test.getPersonByArg(20, list,
                (age, personList) -> personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList()));
        peopleList.forEach(person -> System.out.println(person.getUsername()));

    }

    //使用lambda表达式定义一个 处理的方法
    //filter 方法，参数是一个Predicate 谓语
    //stream 提供了一个将流转换成集合的方法 collect(Collectors.toList())
    public List<Person> getPersonByUsername(String username, List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getUsername().equals("zhangsan"))
                .collect(Collectors.toList());
    }

    //第二种方式,先直接使用lambda表达式将BiFunction定义好，然后直接将方法的两个参数传入到BiFunction.
    public List<Person> getPersonByAge(int age, List<Person> personList) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageArg, Persons) -> {
            return   Persons.stream()
                    .filter(person -> person.getAge() > ageArg)
                    .collect(Collectors.toList());
        };
        return biFunction.apply(age,personList);
    }

    //第三种方式，动作也让他自己传递。 函数式接口的好处。
    public List<Person> getPersonByArg(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }

//    定义一个简单的Person类，然后使用lambda表达式解决一些问题
    @Data
    @AllArgsConstructor
    public static class Person {
        private String username;
        private int age;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
}
