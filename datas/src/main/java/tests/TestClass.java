package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * A是父类 B是子类
 * @author : linghan.ma
 * @Package tests
 * @Description:
 * @date Date : 2020年04月20日 8:09 PM
 **/

public class TestClass {

        public static void main(String[] args) {
            A a = new A();
            B b = new B();
            A ba = new B();
            System.out.println("1-------------");
            System.out.println(A.class.isAssignableFrom(a.getClass()));  //true
            System.out.println(B.class.isAssignableFrom(b.getClass())); //true
            System.out.println(A.class.isAssignableFrom(b.getClass())); //true
            System.out.println(B.class.isAssignableFrom(a.getClass())); //false
            System.out.println(A.class.isAssignableFrom(ba.getClass())); //true
            System.out.println(B.class.isAssignableFrom(ba.getClass())); //true

            System.out.println("2-------------");
            System.out.println(a.getClass().isAssignableFrom(A.class)); //true
            System.out.println(b.getClass().isAssignableFrom(B.class)); //true
            System.out.println(a.getClass().isAssignableFrom(B.class)); //true
            System.out.println(b.getClass().isAssignableFrom(A.class)); //false
            System.out.println(ba.getClass().isAssignableFrom(A.class)); //false
            System.out.println(ba.getClass().isAssignableFrom(B.class)); //true


            System.out.println("3-------------");
            System.out.println(Object.class.isAssignableFrom(b.getClass()));   //true
            System.out.println(Object.class.isAssignableFrom("abc".getClass())); //true


            System.out.println("4-------------");
            System.out.println("a".getClass().isAssignableFrom(Object.class));  //false
            System.out.println("abc".getClass().isAssignableFrom(Object.class)); //false
        }



    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String[] kv =  param.split("=");
            String name = kv[0];
            String value = "";
            if(kv.length>1) {
                value = param.split("=")[1];
            }
            map.put(name, value);
        }
        return map;
    }
}
