package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Public {
    @RequestMapping(value = "/public")
    public String ssm_public(){
        return "public";
    }
}
