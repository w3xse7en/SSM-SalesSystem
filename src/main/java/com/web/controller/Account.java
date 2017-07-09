package com.web.controller;

import com.web.dto.ProductDto;
import com.web.entity.Product;
import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Account {
    @RequestMapping(value = "/account")
    public String account(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        ProductDto productDto = new ProductDto();
        List<Product> productList = productDto.getProductList();
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();
                ) {
            Product product = iterator.next();
            if (product.getIsBuy() == false) {//未购买内容删除
                iterator.remove();
            }
        }
        modelMap.addAttribute("buyList", productList);
        return "account";
    }
}
