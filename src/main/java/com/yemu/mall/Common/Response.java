package com.yemu.mall.Common;

public class Response<T> {

    private int status;
    private String message="ok";
    private T data;

    private Response(int status){
        this.status=status;
    }

    private Response(int status,String message){
        this.status=status;
        this.message=message;
    }
    private Response(int status,T data){
        this.status=status;
        this.data=data;
    }
    private Response(int status,String message,T data){
        this.status=status;
        this.message=message;
        this.data=data;
    }

    public static <T> Response<T> ok(){
        return new Response<>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> Response<T> ok(T data){
        return new Response<>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> Response<T> ok(String message,T data){
        return new Response<>(ResponseCode.SUCCESS.getCode(),message,data);
    }
    public static <T> Response<T> ok(String message){
        return new Response<>(ResponseCode.SUCCESS.getCode(),message);
    }
    public static <T> Response<T> error(){
        return new Response<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> Response<T> error(String message){
        return new Response<>(ResponseCode.ERROR.getCode(),message);
    }
    public static <T> Response<T> error(int errorCode,String message){
        return new Response<>(errorCode,message);
    }
    public static <T> Response<T> createByErrorCodeMessage(int errorCode,String message){
        return new Response<>(errorCode,message);
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
