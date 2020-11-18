package com.someecho.service;

import java.util.UUID;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description: //模拟第三方系统service
 * @date Date : 2020年11月18日 4:42 PM
 **/
public class ThirdPartySystemService {

        public String getPassword(String objectKey){
            //返回一个32位随机数
            return UUID.randomUUID().toString();
        }
}
