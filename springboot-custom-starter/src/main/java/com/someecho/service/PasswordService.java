package com.someecho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年11月18日 4:41 PM
 **/
public class PasswordService {

    //第三方系统获取密码所需的key
    private String objectKey;

    @Autowired
    //模拟的第三方系统service
    private ThirdPartySystemService thirdPartySystemService;

    public String getSystemPassword(String objectKey,String originalPassord){

        if(StringUtils.isEmpty(objectKey)){
            return  originalPassord;
        }
        //从第三方系统获取密码
        String password= thirdPartySystemService.getPassword(objectKey);
        //返回密码
        return password!=null?password:originalPassord;

    }
}
