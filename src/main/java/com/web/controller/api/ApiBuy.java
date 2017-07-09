package com.web.controller.api;

import com.web.dto.ContentDto;
import com.web.dto.TransactionDto;
import com.web.entity.ApiBuyInfo;
import com.web.entity.Transaction;
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
        TransactionDto transactionDto = new TransactionDto();
        ContentDto contentDto = new ContentDto();
        Transaction transaction = new Transaction();
        for (ApiBuyInfo apiBuyInfo : buyList
                ) {
            int price = contentDto.getContent(apiBuyInfo.getId()).getPrice();
            transaction.setContentId(apiBuyInfo.getId());
            transaction.setNum(apiBuyInfo.getNumber());
            transaction.setPrice(price*apiBuyInfo.getNumber());
            transaction.setPersonId(0);
            transaction.setTime(System.currentTimeMillis());
            transactionDto.InsertTransaction(transaction);
        }
        map.addAttribute("code", 200);
        map.addAttribute("message", "success");
        map.addAttribute("result", true);
        return map;
    }
}
