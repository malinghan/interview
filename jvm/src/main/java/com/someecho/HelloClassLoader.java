package com.someecho;

import java.util.Base64;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年10月16日 1:50 AM
 **/
public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            new HelloClassLoader()
                    .findClass("com.someecho.Hello")
                    .newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64 = "qwq1212";
        byte[] bytes = decode(helloBase64);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
