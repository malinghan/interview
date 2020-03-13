package base.stati;

/**
 * @author : linghan.ma
 * @Package base.stati
 * @Description:
 * @date Date : 2019年09月25日 3:23 PM
 *
 * 顺序
 * 1. 父类静态代码块
 * 2. 子类静态代码块
 * 3. 父类非静态代码块
 * 4. 父类构造函数
 * 5. 子类非静态代码块
 * 6. 子类构造函数
 * 7. 子类方法
 *
 * 原理：
 * 方法执行过程分析
 * 1. 先加载常量池(父 -> 子)
 * 2. 再调用 <init>方法,如果有继承关系，会触发父类的<init>,包括初始化非静态代码和构造函数
 * 3. 再调用 子类的<init>方法,初始化子类的非静态代码和构造函数
 *
 * static作用：
 *    - static field  加载阶段，到metaspace的静态区，并有初始化值
 *    - static method 加载阶段，到metaspace的静态方法
 *    - static code   加载阶段，到metaspace的静态方法
 **/
public class Son extends Father{

    static {
        System.out.println("5");
    }

    {
        System.out.println("6");
    }
    public Son(){
        System.out.println("7");
    }

    @Override
    public void print(){
        System.out.println(8);
    }

    public static void staticPrint(){
        System.out.println("19");
    }

    public static void main(String[] args) {
        Father father = new Son();
//        Son father = new Son();
        father.print();
        Son.staticPrint();
    }


}
