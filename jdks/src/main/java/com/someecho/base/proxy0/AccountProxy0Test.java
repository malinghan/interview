package com.someecho.base.proxy0;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:34 PM
 **/
public class AccountProxy0Test {

    public static void main(String[] args) {
        Account account = (Account) new AccountProxyFactory().bind(new AccountImpl());

        System.out.println(account);

        account.queryAccount();
    }
}
