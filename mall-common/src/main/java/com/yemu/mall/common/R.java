package com.yemu.mall.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class R<T> extends ResponseEntity<T> {


    private R(HttpStatus status,PayLoad<T> payLoad){
        super((T) payLoad, status);
    }

    public static <T> R<T> ok(T data){
        PayLoad<T> payLoad = new PayLoad<>(HttpStatus.OK.value(),HttpStatus.OK.toString(),data);
        return new R<>(HttpStatus.OK, payLoad);
    }
    public static <T> R<T> ok(String message,T data){
        PayLoad<T> payLoad = new PayLoad<>(HttpStatus.OK.value(),message,data);
        return new R<>(HttpStatus.OK, payLoad);
    }
    public static <T> R<T> ok(String message){
        PayLoad<T> payLoad = new PayLoad<>(HttpStatus.OK.value(),message,null);
        return new R<>(HttpStatus.OK, payLoad);
    }
    public static <T> R<T> error(){
        PayLoad<T> payLoad = new PayLoad<>(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),null);
        return new R<>(HttpStatus.BAD_REQUEST, payLoad);
    }
    public static <T> R<T> error(String message){
        PayLoad<T> payLoad = new PayLoad<>(HttpStatus.BAD_REQUEST.value(),message,null);
        return new R<>(HttpStatus.BAD_REQUEST, payLoad);
    }
    public static <T> R<T> error(HttpStatus status,String message){
        PayLoad<T> payLoad = new PayLoad<>(status.value(),message,null);
        return new R<>(status, payLoad);
    }

    /**
     * 自定义错误状态码以请求成功形式返回
     * @param statusCode 状态码
     * @param message 信息
     * @param <T> 泛型
     * @return 封装的信息
     */
    public static <T> R<T> error(int statusCode,String message){
        PayLoad<T> payLoad = new PayLoad<>(statusCode,message,null);
        return new R<>(HttpStatus.OK, payLoad);
    }





    private static class PayLoad<T>{
        int status;
        String message;
        T data;
        PayLoad(int status,String message,T data){
            this.status = status;
            this.message = message;
            this.data = data;
        }
        public int getStatus() {
            return status;
        }
        public String getMessage() {
            return message;
        }
        public T getData() {
            return data;
        }
    }
}
