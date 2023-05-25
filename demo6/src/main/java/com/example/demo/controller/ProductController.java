package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;
import com.example.demo.util.JsonResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @create 2022-12-07 9:35
 */
@RestController
@MapperScan("products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService productService;
    @RequestMapping("host_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHostList();
        return new JsonResult<List<Product>>(OK, data);
    }
}
