package com.someecho.proxy;

/**
 * @author : linghan.ma
 * @Package com.someecho.proxy
 * @Description:
 * @date Date : 2020年11月17日 4:36 AM
 **/
public class UserManagerImpProxy implements UserManager {

    private UserManager userManager;

    public UserManagerImpProxy(UserManager userManager){
        this.userManager = userManager;
    }

    @Override
    public void addUser() {
        System.out.println("UserManagerImpProxy.addUser before");
        userManager.addUser();
        System.out.println("UserManagerImpProxy.addUser after");
    }

    @Override
    public void delUser() {
        System.out.println("UserManagerImpProxy.delUser before");
        userManager.delUser();
        System.out.println("UserManagerImpProxy.delUser after");
    }

    @Override
    public String findUser() {
        return userManager.findUser();
    }
}
