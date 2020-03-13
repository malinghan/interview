package base.seriable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author : linghan.ma
 * @Package base.seriable
 * @Description:
 * @date Date : 2019年09月16日 7:02 PM
 **/
public class Store2Test {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
        Test2 test = new Test2();
        test.i = 1;
        out.writeObject(test);
        out.flush();
        test.i = 2;
        out.writeObject(test);
        out.close();
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
        Test2 t1 = (Test2) oin.readObject();
        Test2 t2 = (Test2) oin.readObject();
        System.out.println(t1.i);
        System.out.println(t2.i);
    }
}
