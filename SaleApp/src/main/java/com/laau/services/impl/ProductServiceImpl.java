/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laau.services.impl;

import com.laau.pojo.Product;
import com.laau.repositories.ProductRepository;
import com.laau.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepository.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product product) {
        this.productRepository.addOrUpdate(product);
    }
    
}
