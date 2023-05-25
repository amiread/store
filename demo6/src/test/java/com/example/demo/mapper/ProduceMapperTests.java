package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author admin
 * @create 2022-12-07 9:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProduceMapperTests {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void findHotList(){
        List<Product> list = productMapper.findHostList();
        System.out.println("count=" + list.size());
        for (Product item : list) {
            System.out.println(item);
        }

    }
}
