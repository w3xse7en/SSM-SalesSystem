package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class EditSubmit {
    @RequestMapping(value = "/editSubmit")
    public String editSubmit(){
        return "editSubmit";
    }
}
