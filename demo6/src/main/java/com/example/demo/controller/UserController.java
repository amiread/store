package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.UsernameDuplicateException;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.nio.file.Files;

import static com.example.demo.controller.BaseController.OK;

/**
 * @author admin
 * @create 2022-12-05 15:35
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;


    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        // 调用业务对象执行注册
        userService.reg(user);
        // 返回
        return new JsonResult<Void>(OK);

    }
    @RequestMapping("login")
    public JsonResult<User>login(String username, String password, HttpSession session){
        User data=userService.login(username,password);
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<User>(OK,data);

    }
    @RequestMapping("change_password")
    public JsonResult<Void>changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<Void>(OK);

    }
    @RequestMapping("get_by_uid")
    public JsonResult<User>getbyuid(HttpSession session){
        Integer uid=getUidFromSession(session);
        User data=userService.getByUid(uid);
        return new JsonResult<User>(OK, data);

    }
    @RequestMapping("change_info")
    public JsonResult<Void>changeinfo(HttpSession session,User user){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        return new JsonResult<Void>(OK);
    }




}
