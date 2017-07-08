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
import java.util.List;
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
        System.out.println("-------------");
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("type",0);
        modelMap.addAttribute("RequestParameters",map);

        ProductDto productDto = new ProductDto();
        List<Product> productList = productDto.getProductList();
        for (Product product: productList
             ) {
            System.out.println(product.getTitle());
        }
        modelMap.addAttribute("productList",productList);
        return "index";
    }

    @RequestMapping(value = "/index")
    public String reindex(){
//        System.out.println(type);
        return "redirect:/";
    }
}
