package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;

@SpringBootTest
class Demo6ApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void getConnection () throws Exception{
        System.out.println(dataSource.getConnection());
    }

}
