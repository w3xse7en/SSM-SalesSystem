package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mew on 2017/6/30.
 */
public class Account {
    @RequestMapping(value = "/account")
    public String account(){
        return "account";
    }
}
