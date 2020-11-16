package com.someecho.proxy;

/**
 * @author : linghan.ma
 * @Package com.someecho.proxy
 * @Description:
 * @date Date : 2020年11月17日 4:35 AM
 **/
public class UserManagerImp implements UserManager {
    @Override
    public void addUser() {
        System.out.println("UserManagerImp.addUser");
    }

    @Override
    public void delUser() {
        System.out.println("UserManagerImp.delUser");
    }

    @Override
    public String findUser() {
        return "UserManagerImp.findUser";
    }
}
