package com.example.demo.controller;

import com.example.demo.service.ex.*;
import com.example.demo.util.JsonResult;
import jdk.jfr.Experimental;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.rmi.ServerException;

/**
 * @author admin
 * @create 2022-12-05 15:48
 */
public class BaseController {
    public static final int OK=200;
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
    @ExceptionHandler(ServerException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
        } else if (e instanceof UserNotFoundException){
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
        } else if (e instanceof UpdateException){
            result.setState(4003);
        }
        else if (e instanceof InsertException) {
            result.setState(5000);
        }


            return result;
    }
}

