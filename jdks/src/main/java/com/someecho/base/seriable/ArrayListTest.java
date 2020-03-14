package com.someecho.base.seriable;




import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.seriable
 * @Description: 对arraylist的序列化测试
 * @date Date : 2019年09月16日 7:44 PM
 **/
public class ArrayListTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> stringList = new ArrayList<String>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hollis");
        stringList.add("chuang");
        System.out.println("init StringList" + stringList);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("stringlist"));
        objectOutputStream.writeObject(stringList);
        objectOutputStream.close();
        File file = new File("stringlist");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<String> newStringList = (List<String>)objectInputStream.readObject();
        objectInputStream.close();
        if(file.exists()){
            file.delete();
        }
        System.out.println("new StringList" + newStringList);
    }
}
