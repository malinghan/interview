package com.someecho;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description: 添加引用类的方式
 * 拿到当前执行类的classloader 反射调用AddUrl方法添加jar或路径 (JDK9 无效)
 * @date Date : 2020年10月16日 1:58 AM
 **/
public class JvmAppClassLoaderAddURL {

    public static void main(String[] args) throws Exception {
        String appPath = "file:/Users/malinghan/IdeaProjects/learning-space/interview/jvm/src/main/java";
        URLClassLoader urlClassLoader = (URLClassLoader) JvmAppClassLoaderAddURL.class.getClassLoader();

        Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);

        addURL.setAccessible(true);

        URL url = new URL(appPath);

        addURL.invoke(urlClassLoader,url);

        Class.forName("com.someecho.Hello"); //效果Class.forName().newInstance一样
    }
}
