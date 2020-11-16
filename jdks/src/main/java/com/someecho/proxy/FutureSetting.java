package com.someecho.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2020年04月02日 8:49 AM
 **/
public class FutureSetting {

    private static final Logger LOGGER = LoggerFactory.getLogger(FutureSetting.class);

    static ThreadLocal<InvokeContext> argsThreadLocal = new ThreadLocal<>();

    private static ConcurrentHashMap<Class, Object> proxyCache = new ConcurrentHashMap<>();

//    public static <T> T bean(T object) {
//        final InvokeContext argsSetting = getInvokeContext();
//        argsSetting.setObject(object);
//        Object proxy = proxyCache.get(object.getClass());
//        if (proxy != null){
//            return (T) proxy;
//        }
//        proxy = getJdkProxy(object);
//        proxyCache.put(object.getClass(), proxy);
//        return (T) proxy;
//    }

    public static <T> T beanAndInterfaces(T object, Class<?> c) {

        final InvokeContext argsSetting = getInvokeContext();
        argsSetting.setObject(object);
        Object proxy = proxyCache.get(object.getClass());
        if (proxy != null) {
            return (T) proxy;
        }
        proxy = getJdkProxy(object, c);
        proxyCache.put(object.getClass(), proxy);
        return (T) proxy;
    }

    private static Object getCglibProxy(Object object) throws ProxyError {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new SettingInvocationHandler(object));
        return enhancer.create();
    }

    private static Object getJdkProxy(Object object) throws ProxyError {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new SettingInvocationHandler(object));
    }

    private static Object getJdkProxy(Object object, Class<?> c) throws ProxyError {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), new Class[]{c}, new SettingInvocationHandler(object));
    }

    static protected InvokeContext getInvokeContext() {
        InvokeContext argsSetting = argsThreadLocal.get();
        if (null == argsSetting) {
            argsThreadLocal.set(argsSetting = new InvokeContext());
        }
        return argsSetting;
    }


    static protected class SettingInvocationHandler implements InvocationHandler, MethodInterceptor {
        private InvokeContext argsSetting;
        private Object subObject;

        public SettingInvocationHandler(Object subObject) {
            this.subObject = subObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            InvokeContext argsSetting = getInvokeContext();
            argsSetting.method = method;
            argsSetting.args = args;
            return null;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, org.springframework.cglib.proxy.MethodProxy methodProxy) throws Throwable {
            InvokeContext argsSetting = getInvokeContext();
            argsSetting.method = method;
            argsSetting.args = args;
            return null;
        }
    }
}

