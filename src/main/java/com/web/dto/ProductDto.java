package com.web.dto;

import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.entity.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
public class ProductDto {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
    ProductDao dao = context.getBean(ProductDao.class);

    public List<Product> getProductList() {
        List<Product> productList = dao.getProductList();
        TransactionDto transactionDto = new TransactionDto();
        for (Product product : productList) {
            setProductInfo(transactionDto, product);
        }
        return productList;
    }

    public Product getProduct(int id) {
        TransactionDto transactionDto = new TransactionDto();
        Product product = dao.getProduct(id);
        setProductInfo(transactionDto, product);
        return product;
    }

    public void setProductInfo(TransactionDto transactionDto, Product product) {
        Transaction transaction = null;
        if (null != (transaction = transactionDto.getTransaction(product.getId()))) {
            product.setIsBuy(true);
            product.setIsSell(true);
            product.setBuyPrice(transaction.getPrice());
            product.setBuyNum(transaction.getNum());
            product.setTime(transaction.getTime());
        } else {
            product.setIsBuy(false);
            product.setIsSell(false);
        }
    }
}
