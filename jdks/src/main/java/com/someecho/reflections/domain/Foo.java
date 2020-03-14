package com.someecho.reflections.domain;

import com.sun.istack.internal.NotNull;

import java.util.StringJoiner;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.domain
 * @Description:
 * @date Date : 2020年03月14日 8:19 PM
 **/
public class Foo implements SuperFoo{
    private String name;

    public Foo(){}

    public Foo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Foo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
