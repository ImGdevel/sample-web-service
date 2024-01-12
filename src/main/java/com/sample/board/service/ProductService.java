package com.sample.board.service;


import com.sample.board.data.dto.ProductDto;

public interface ProductService {

  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

  ProductDto getProduct(String productId);

}
