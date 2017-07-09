package com.web.controller;

import com.web.dto.ContentDto;
import com.web.dto.ProductDto;
import com.web.dto.TransactionDto;
import com.web.entity.Content;
import com.web.entity.Product;
import com.web.entity.Transaction;
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
public class Show {
    @RequestMapping(value = "/show")
    public String show(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam("id") int id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());

        }
        ProductDto productDto = new ProductDto();
        Product product = productDto.getProduct(id);
        modelMap.addAttribute("product", product);
        return "show";
    }
}
