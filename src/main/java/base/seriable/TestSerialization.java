package base.seriable;

import java.io.*;

/**
 * @author : linghan.ma
 * @Package base.seriable
 * @Description:
 * @date Date : 2019年09月16日 8:09 PM
 **/
public class TestSerialization implements Serializable
    {
        private transient int    num;

        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        private void writeObject(java.io.ObjectOutputStream s)
                throws java.io.IOException
        {
            s.defaultWriteObject();
            s.writeObject(num);
            System.out.println("writeObject of "+this.getClass().getName());
        }

        private void readObject(java.io.ObjectInputStream s)
                throws java.io.IOException, ClassNotFoundException
        {
            s.defaultReadObject();
            num = (Integer) s.readObject();
            System.out.println("readObject of "+this.getClass().getName());
        }

        public static void main(String[] args)
        {
            TestSerialization test = new TestSerialization();
            test.setNum(10);
            System.out.println("序列化之前的值："+test.getNum());
            // 写入
            try
            {
                ObjectOutputStream outputStream = new ObjectOutputStream(
                        new FileOutputStream("test.tmp"));
                outputStream.writeObject(test);
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            // 读取
            try
            {
                ObjectInputStream oInputStream = new ObjectInputStream(
                        new FileInputStream("test.tmp"));
                try
                {
                    TestSerialization aTest = (TestSerialization) oInputStream.readObject();
                    System.out.println("读取序列化后的值："+aTest.getNum());
                } catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
