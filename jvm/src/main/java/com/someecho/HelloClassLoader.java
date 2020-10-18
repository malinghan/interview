package com.someecho;

import java.io.*;
import java.util.Base64;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年10月16日 1:50 AM
 **/
public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        try {
            Object o = new HelloClassLoader()
                    .findClass("Hello")
                    .newInstance();
            System.out.println(o.toString());
            o.getClass().getMethod("hello",new Class[]{}).invoke(o);
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
        File file = new File("/Users/malinghan/IdeaProjects/learning-space/interview/jvm/src/main/java/com/someecho/Hello.xlass");
//        File file = new File("/Users/malinghan/IdeaProjects/learning-space/interview/jvm/src/main/java/com/someecho/MovingAverage.class");

        byte[] bytes = readString1(file);
        System.out.println(bytes);
//        String helloS = Base64.getEncoder().encodeToString(helloBase64);
//        String helloS = new String(helloBase64);
//        System.out.println(helloBase64);
//        byte[] bytes = decode(helloBase64);
//        byte[] bytes = readString2(file);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] encode(byte[] base64){
        return Base64.getEncoder().encode(base64);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }

    /* 貌似是说网络环境中比较复杂，每次传过来的字符是定长的，用这种方式？*/
    public byte[] readString1(File file){
        // 读取类文件的字节
        try {
            InputStream ins = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            byte[] res =  baos.toByteArray();
            for (int i = 0; i < res.length; i++) {
                res[i] = (byte) (255 - res[i]);
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
