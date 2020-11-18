package com.someecho.service;

import com.someecho.configuration.BaseServiceProperties;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年11月18日 4:44 PM
 **/
public class BaseStarterService {

    public void addServiceName(BaseServiceProperties baseServiceProperties){
        System.out.println("serviceName:"+baseServiceProperties.getServiceName()+"----"+"serviceVersion"+baseServiceProperties.getServiceVersion());
    }
}
