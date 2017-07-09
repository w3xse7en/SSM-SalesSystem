package com.web.controller;

import com.web.dto.ProductDto;
import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Edit {
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        if (id != null) {
            ProductDto productDto = new ProductDto();
            modelMap.addAttribute("product", productDto.getProduct(id));
        }
        return "edit";
    }
}
