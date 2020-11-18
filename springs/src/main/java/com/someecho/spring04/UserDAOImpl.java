package com.someecho.spring04;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring04
 * @Description:
 * @date Date : 2020年11月18日 2:31 PM
 **/
public class UserDAOImpl implements UserDAO{

    @Override
    public void save() {
        System.out.println("=====UserDAOImpl.save()");
    }
}
