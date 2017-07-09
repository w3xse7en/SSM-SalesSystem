package com.web.controller;

import com.web.dto.ProductDto;
import com.web.entity.Product;
import com.web.service.CookieInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Index {
    @RequestMapping(value = {"/", "/index", ""})
    public String index(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "type", required = false) Integer type) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        if (null == type) {
            type = 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("type", type);
        modelMap.addAttribute("RequestParameters", map);

        ProductDto productDto = new ProductDto();
        List<Product> productList = productDto.getProductList();
        if (type.equals(1)) {
            for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();
                    ) {
                Product product = iterator.next();
                if (product.getIsBuy() == true) {//已购买内容删除
                    iterator.remove();
                }
            }
        }
        modelMap.addAttribute("productList", productList);
        return "index";
    }
}
