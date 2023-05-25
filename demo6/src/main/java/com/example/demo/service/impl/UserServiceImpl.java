package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author admin
 * @create 2022-12-05 9:55
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username= user.getUsername();
        User result=userMapper.findByUsername(username);
        if(result!=null){
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }
        Date now=new Date();
        String salt= UUID.randomUUID().toString().toUpperCase();
        String MD5password=getMd5Password(user.getPassword(),salt);
        user.setPassword(MD5password);
        user.setIsDelete(0);
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        Integer rows=userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        User result=userMapper.findByUsername(username);
        if(result==null){
            throw new UserNotFoundException("用户数据不存在");
        }
        if(result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        String salt= result.getSalt();
        String md5password=getMd5Password(password,salt);
        if(!result.getPassword().equals(md5password)){
            throw new PasswordNotMatchException("密码错误");
        }
        User user=new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result=userMapper.findByuid(uid);
        if(result==null){
            throw new UserNotFoundException("用户数据不存在");
        }
        if(result.getIsDelete().equals(1)){
            throw new UserNotFoundException("用户数据不存在");
        }
        String salt=result.getSalt();
        String oldMd5Password=getMd5Password(oldPassword,salt);
        if(!result.getPassword().contentEquals(oldMd5Password)){
            throw new PasswordNotMatchException("原密码输入错误");
        }
        String newMd5Password=getMd5Password(newPassword,salt);
        Date now=new Date();
        Integer rows=userMapper.updatePasswordByuid(uid,newMd5Password,username,now);
        if(rows != 1){
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");

        }

    }

    @Override
    public User getByUid(Integer uid) {
        User result=userMapper.findByuid(uid);
        if(result==null){
            throw new UserNotFoundException("用户不存在");
        }
        if(result.getIsDelete().equals(1)){
            throw  new UserNotFoundException("用户不存在");
        }
        User user=new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result=userMapper.findByuid(uid);
        if(result==null){
            throw new UserNotFoundException("用户不存在");
        }
        if(result.getIsDelete().equals(1)){
            throw  new UserNotFoundException("用户不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows=userMapper.updateInfoByUid(user);
        if(rows!=1){
            throw  new UserNotFoundException("更新用户数据时出现未知错误，请联系系统管理员");

        }

    }

    private String getMd5Password(String password, String salt) {
        for (int i = 0; i <3 ; i++) {
            password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
