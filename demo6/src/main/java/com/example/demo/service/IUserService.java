package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @author admin
 * @create 2022-12-05 9:53
 */
public interface IUserService {
    void reg(User user);
    User login(String username, String password);
    public void changePassword(Integer uid,String username,String oldPassword,String newPassword);
    User getByUid(Integer uid);
    void changeInfo(Integer uid,String username,User user);
}
