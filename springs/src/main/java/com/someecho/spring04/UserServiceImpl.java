package com.someecho.spring04;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring04
 * @Description:
 * @date Date : 2020年11月18日 2:32 PM
 **/
@Service
//相当于配置文件中的:<bean id="userService" class="com.ssm.annotation.UserServiceImpl" />
public class UserServiceImpl implements IUserService {

    @Resource
    //当于配置文件中的:<property name="userDao"  ref="userDao"/>
//    @Autowied
    private UserDAO userDAO;


    @Override
    public void save() {
          this.userDAO.save();
        System.out.println("userservice....save...");
    }

    //set注入
//    public void setUserDao(UserDAO userDao) {
//        this.userDAO = userDao;
//    }

}
