package com.web.controller.api;

import com.web.entity.Person;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mew on 2017/6/30.
 */
public class ApiLogin {
    @RequestMapping(value = "/api/login")
    public String Login(@RequestParam("userName") String userName, @RequestParam("password") String password, ModelMap map){
        Person user = new Person();
        user.setUserName(userName);
        user.setUserPassword(password);
        map.addAttribute("user",user);
        return "user";
    }
}
