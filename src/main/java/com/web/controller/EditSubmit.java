package com.web.controller;

import com.web.dto.ContentDto;
import com.web.entity.Content;
import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String editSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
                             @RequestParam("price") int price, @RequestParam("title") String title,
                             @RequestParam("image") String pic, @RequestParam("summary") String summary,
                             @RequestParam("detail") String detail, @RequestParam(value = "id", required = true) Integer id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", id);
        modelMap.addAttribute("RequestParameters", map);

        ContentDto contentDto = new ContentDto();
        Content content = contentDto.getContent(id);
        //修改原数据
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(pic);
        content.setSummary(summary);
        content.setDetail(detail);

        contentDto.updateContent(content);
        content = contentDto.getContent(id);
        modelMap.addAttribute("product", content);
        return "editSubmit";
    }
}
