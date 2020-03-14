package com.someecho.reflections.domain;

import java.util.StringJoiner;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.domain
 * @Description:
 * @date Date : 2020年03月14日 8:19 PM
 **/
public class Foo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Foo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
