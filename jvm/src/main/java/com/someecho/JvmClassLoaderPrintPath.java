package com.someecho;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;


public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {

        //启动类加载器
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("bootstrapClassLoader...");
        for (URL url : urls) {
            System.out.println("==>"+url.toExternalForm());
        }

        //拓展类加载器
        printClassLoader("extenalClassLoader...",JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        //应用类加载器
        printClassLoader("applicationClassLoader...",JvmClassLoaderPrintPath.class.getClassLoader());
    }

    public static void printClassLoader(String name,ClassLoader CL){
        if(CL != null){
            System.out.println(name+"ClassLoader ->"+CL.toString());
            printURLForClassLoader(CL);
        }else {
            System.out.println(name+"ClassLoader -> null");
        }
    }

    public static void printURLForClassLoader(ClassLoader CL){
        Object ucp = insightField(CL,"ucp");
        Object path = insightField(ucp,"path");
        ArrayList ps = (ArrayList) path;
        for (Object p : ps) {
            System.out.println("==>"+p.toString());
        }
    }


    private static Object insightField(Object obj,String fName){
        Field f  = null;
       try {
           if (obj instanceof URLClassLoader) {
               f = URLClassLoader.class.getDeclaredField(fName);
           }else {
               f = obj.getClass().getDeclaredField(fName);
           }
           f.setAccessible(true);
           return f.get(obj);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }
}
