package com.web.dto;

import com.web.dao.PersonDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mew on 2017/7/1.
 */
public class PersonDto {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
    PersonDao dao = context.getBean(PersonDao.class);
    public boolean isUser(String userName,String userPassword) {
        if (userPassword.equals(dao.getuserPassword(userName))){
            return true;
        }
        return false;
    }
    public int getType(String userName){
        return dao.getuserType(userName);
    }
}
