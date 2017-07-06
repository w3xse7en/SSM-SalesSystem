package com.web.controller;

import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Index {
    @RequestMapping(value = "/")
    public String index(ModelMap modelMap, HttpServletRequest request){
        CookieInfo cookieInfo = new CookieInfo(request);
        if(cookieInfo.isCookieUser()){
            modelMap.addAttribute("user",cookieInfo.getCookieUser());
        }
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("type",1);
        modelMap.addAttribute("RequestParameters",map);
        return "index";
    }

    @RequestMapping(value = "/index")
    public String reindex(){
        return "redirect:/";
    }
}
