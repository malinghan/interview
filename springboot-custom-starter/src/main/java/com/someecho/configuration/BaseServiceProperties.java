package com.someecho.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : linghan.ma
 * @Package com.someecho.config
 * @Description: 通过@ConfigurationProperties注解获取属性值
 * @date Date : 2020年11月18日 4:43 PM
 **/
@ConfigurationProperties(prefix = "project.starter")
public class BaseServiceProperties {

    private String serviceName;
    private String serviceVersion;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }
}
