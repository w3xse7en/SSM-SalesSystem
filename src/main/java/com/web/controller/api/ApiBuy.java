package com.web.controller.api;

import com.web.entity.ApiBuyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Mew on 2017/7/9.
 */
@Controller
public class ApiBuy {
    @RequestMapping(value = "/api/buy")
    @ResponseBody
    public ModelMap Buy(@RequestBody List<ApiBuyInfo> buyList, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        for (ApiBuyInfo apiBuyInfo : buyList
                ) {
            System.out.println("id:" + apiBuyInfo.getId());
            System.out.println("num:" + apiBuyInfo.getNum());
        }
        map.addAttribute("code", 200);
        map.addAttribute("message", "success");
        map.addAttribute("result", true);
        return map;
    }
}
