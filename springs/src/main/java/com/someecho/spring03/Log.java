package com.someecho.spring03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 4:22 AM
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface  Log {
    String value() default "Log";
}
