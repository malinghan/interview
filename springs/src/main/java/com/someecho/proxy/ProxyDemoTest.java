package com.someecho.proxy;

/**
 * @author : linghan.ma
 * @Package com.someecho.proxy
 * @Description:
 * @date Date : 2020年11月17日 4:38 AM
 **/
public class ProxyDemoTest {

    public static void main(String[] args) {
        UserManager u = new UserManagerImpProxy(new UserManagerImp());

        u.addUser();
        u.delUser();
    }
}
