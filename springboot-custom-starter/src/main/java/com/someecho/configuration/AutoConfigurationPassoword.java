package com.someecho.configuration;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年11月18日 4:48 PM
 **/

import com.someecho.condition.LinuxCondition;
import com.someecho.service.BaseStarterService;
import com.someecho.service.PasswordService;
import com.someecho.service.ThirdPartySystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//自动加载配置文件属性值
@EnableConfigurationProperties(BaseServiceProperties.class)
@Import(BeanConfiguration.class)
//判断当前环境是否为windows
@Conditional(LinuxCondition.class)
//判断属性spring.project.ThirdPartySystemService.isPassword是否等于true
@ConditionalOnProperty(prefix = "spring.project.ThirdPartySystemService",value = "enablePassword", havingValue = "true",matchIfMissing = true)
public class AutoConfigurationPassoword {
    @Autowired
    private BaseServiceProperties baseServiceProperties;
    @Autowired
    private BaseStarterService baseWindowsService;

    //加载第三方系统service
    @Bean("thirdPartySystemService")
    public ThirdPartySystemService thirdPartySystemService(){
        baseWindowsService.addServiceName(baseServiceProperties);
        return new ThirdPartySystemService();
    }
    @Bean
    //判断IOC容器中是否存在ThirdPartySystemService类，存在则创建PasswordService bean
    @ConditionalOnClass(ThirdPartySystemService.class)
    public PasswordService passwordService(){
        baseWindowsService.addServiceName(baseServiceProperties);
        return new PasswordService();
    }
}