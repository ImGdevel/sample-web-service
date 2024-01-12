package com.sample.board.data.dao.impl;

import com.sample.board.data.dao.ProductDAO;
import com.sample.board.data.entity.Product;
import com.sample.board.data.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    //private final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        //LOGGER.info("[saveProduct] product 정보 저장. productId : {}", product.getId());
        Product product1 = productRepository.save(product);
        //LOGGER.info("[saveProduct] product 정보 저장완료. productId : {}", product1.getId());
        return product1;
    }

    @Override
    public Product getProduct(String productId) {
        //LOGGER.info("[getProduct] product 정보 요청. productId : {}", productId);
        Product product = productRepository.getById(productId);
        //LOGGER.info("[getProduct] product 정보 요청 완료. productId : {}", product.getId());
        return product;
    }

}
