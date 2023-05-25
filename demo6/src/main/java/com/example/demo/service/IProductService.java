package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

/**
 * @author admin
 * @create 2022-12-07 9:22
 */
public interface IProductService {
    List<Product> findHostList();
}
