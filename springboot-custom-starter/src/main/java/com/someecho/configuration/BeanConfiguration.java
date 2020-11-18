package com.someecho.configuration;

import com.someecho.service.BaseStarterService;
import org.springframework.context.annotation.Configuration;

/**
 * @author : linghan.ma
 * @Package com.someecho.configuration
 * @Description:
 * @date Date : 2020年11月18日 4:51 PM
 **/
@Configuration
public class BeanConfiguration {

    public BaseStarterService baseStarterService(){
        return new BaseStarterService();
    }
}