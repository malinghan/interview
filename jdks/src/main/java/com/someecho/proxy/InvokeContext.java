package com.someecho.proxy;

import java.lang.reflect.Method;

/**
 * Created by lulu on 17/7/27.
 */
public class InvokeContext {
    public Class beanClass;
    public Object[] args;
    public transient Object  bean;
    public Method method = null;

    public void setObject(Object object) {
        bean = object;
        beanClass = null;
        if (null != object){
            beanClass = object.getClass();
        }
    }

    public void setMethod(Method method, Object[] args) {
        this.method = method;
        this.args = args;
    }
}
