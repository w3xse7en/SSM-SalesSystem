package com.web.service;

import com.web.entity.Product;
import com.web.service.impl.TransactionImpl;

import java.util.List;

/**
 * Created by Mew on 2017/7/29.
 */
public interface ProductService {
    List<Product> getProductList();

    Product getProduct(int id);

    void setProductInfo(TransactionImpl transactionImpl, Product product);
}
