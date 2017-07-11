package com.web.dto;

import com.web.dao.TransactionDao;
import com.web.entity.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mew on 2017/7/8.
 */
public class TransactionDto {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
    TransactionDao dao = context.getBean(TransactionDao.class);

    public Transaction getTransaction(int id) {
        return dao.getTransaction(id);
    }

    public void InsertTransaction(Transaction transaction) {
        dao.InsertTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        dao.updateTransaction(transaction);
    }
}
