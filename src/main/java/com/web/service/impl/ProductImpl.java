package com.web.service.impl;

import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.entity.Transaction;
import com.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
@Service
public class ProductImpl implements ProductService {
    //    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//    ProductDao dao = context.getBean(ProductDao.class);
    private ProductDao productDao;
    private TransactionImpl transactionImpl;

    @Autowired
    public void setDao(ProductDao productDao, TransactionImpl transactionImpl) {
        this.productDao = productDao;
        this.transactionImpl = transactionImpl;
    }

    public List<Product> getProductList() {
        List<Product> productList = productDao.getProductList();
//        TransactionImpl transactionImpl = new TransactionImpl();
        for (Product product : productList) {
            setProductInfo(transactionImpl, product);
        }
        return productList;
    }

    public Product getProduct(int id) {
//        TransactionImpl transactionImpl = new TransactionImpl();
        Product product = productDao.getProduct(id);
        setProductInfo(transactionImpl, product);
        return product;
    }

    public void setProductInfo(TransactionImpl transactionImpl, Product product) {
        Transaction transaction = null;
        if (null != (transaction = transactionImpl.getTransaction(product.getId()))) {
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
