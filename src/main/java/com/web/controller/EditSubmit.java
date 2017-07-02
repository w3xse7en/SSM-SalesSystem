package com.web.controller;

import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class EditSubmit {
    @RequestMapping(value = "/editSubmit")
    public String editSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        CookieInfo cookieInfo = new CookieInfo(request);
        if(cookieInfo.isCookieUser()){
            modelMap.addAttribute("user",cookieInfo.getCookieUser());
        }
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("id",0);
        modelMap.addAttribute("RequestParameters",map);
        return "editSubmit";
    }
}
