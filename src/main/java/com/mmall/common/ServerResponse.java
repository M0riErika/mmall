package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL )
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status, String msg, T data){
        this.data=data;
        this.msg=msg;
        this.status=status;
    }

    private ServerResponse(int status, String msg){
        this.msg=msg;
        this.status=status;
    }

    private ServerResponse(int status, T data){
        this.data=data;
        this.status=status;
    }

    private ServerResponse(int status){
        this.status=status;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    //登陆成功
    public static <T>ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T>ServerResponse<T> createBySuccessMsg(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T>ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T>ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    //登陆失败
    public static <T>ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T>ServerResponse<T> createByErrorMessage(String errormsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errormsg);
    }

    public static <T>ServerResponse<T> createByErrorCodeMessage(int code, String errormsg){
        return new ServerResponse<T>(code,errormsg);
    }

}
