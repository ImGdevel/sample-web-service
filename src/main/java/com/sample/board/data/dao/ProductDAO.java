package com.sample.board.data.dao;

import com.sample.board.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);
    Product getProduct(String productId);

}
