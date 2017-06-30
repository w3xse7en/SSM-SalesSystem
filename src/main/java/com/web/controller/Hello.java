package com.web.controller;

import com.web.dao.PersonDao;
import com.web.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mew on 2017/6/30.
 */

@Controller
public class Hello {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
    PersonDao dao = context.getBean(PersonDao.class);
    Person person = dao.getContent(1);
    @RequestMapping("/hello")
    public String show(ModelMap map){
        map.addAttribute("user",person);
        return "user";
    }

}
