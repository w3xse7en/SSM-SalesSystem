package com.web.service;

import com.web.dao.PersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mew on 2017/7/1.
 */
@Service
public class IsUser {
    @Resource
    private PersonDao dao;
    public boolean isUser(String userName,String userPassword) {
        if (userPassword.equals(dao.getuserPassword(userName))){
            return true;
        }
        return false;
    }
}
