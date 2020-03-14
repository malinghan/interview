package com.someecho.base.seriable;

import java.io.*;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.seriable
 * @Description:
 * @date Date : 2019年09月16日 7:00 PM
 **/
public class StoreTest {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
        Test test = new Test();
        //试图将对象两次写入文件
        out.writeObject(test);
        out.flush();
        System.out.println(new File("result.obj").length());
        out.writeObject(test);
        out.close();
        System.out.println(new File("result.obj").length());

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                "result.obj"));
        //从文件依次读出两个文件
        Test t1 = (Test) oin.readObject();
        Test t2 = (Test) oin.readObject();
        oin.close();

        //判断两个引用是否指向同一个对象
        System.out.println(t1 == t2);
    }
}
