package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.ServiceException;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author admin
 * @create 2022-12-04 20:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user01");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user01";
        User result = userMapper.findByUsername(username);
        System.out.println(result);

    }
    @Test
    public void updatePasswordByuid(){
        Integer uid = 7;
        String password = "123456";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByuid(uid, password, modifiedUser,
                modifiedTime);
        System.out.println("rows=" + rows);

    }
    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByuid(uid);
        System.out.println(result);
    }
    @Test
    public void updateInfoByUid(){
        User user=new User();
        user.setUid(8);
        user.setPhone("123456789");
        user.setEmail("11511@.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows=userMapper.updateInfoByUid(user);
        System.out.println("rows="+rows);


    }

}
