package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author admin
 * @create 2022-12-07 9:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
    @Autowired
    private IProductService productService;

    @Test
    public void findHostList() {
        try {
            List<Product> list = productService.findHostList();
            System.out.println("count=" + list.size());
            for (Product item : list) {
                System.out.println(item);
            }
            } catch(ServiceException e){
                System.out.println(e.getClass().getSimpleName());
                System.out.println(e.getMessage());
            }

        }
    }

