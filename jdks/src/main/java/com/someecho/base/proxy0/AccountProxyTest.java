package com.someecho.base.proxy0;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:28 PM
 **/
public class AccountProxyTest {

    public static void main(String[] args) {
        Account account = new AccountImpl();
        AccountProxy proxy = new AccountProxy(account);
        proxy.queryAccount();
        proxy.updateAccount();
    }
}
