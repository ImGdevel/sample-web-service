package com.sample.board.data.handler;


import com.sample.board.data.entity.Product;

public interface ProductDataHandler {

  Product saveProductEntity(String productId, String productName, int productPrice, int productStock);

  Product getProductEntity(String productId);

}
