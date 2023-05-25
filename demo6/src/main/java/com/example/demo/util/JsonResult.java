package com.example.demo.util;

import org.aspectj.bridge.Message;

import java.io.Serializable;

/**
 * @author admin
 * @create 2022-12-05 10:38
 */
public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;
    public JsonResult(){
        super();
    }
    public JsonResult(Integer state){
        super();
        this.state=state;
    }
    public JsonResult(Throwable e){
        super();
        this.message= e.getMessage();
    }
    public JsonResult(Integer state,E data){
        super();
        this.state=state;
        this.data=data;

    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
