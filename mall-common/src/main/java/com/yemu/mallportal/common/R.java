package com.yemu.mallportal.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class R<T> extends ResponseEntity<T> {
    private HttpStatus status;
    private String message="";
    private T data;

    private R(HttpStatus status){
        super(status);
        this.status=status;
    }

    private R(HttpStatus status, String message){
        super((T) message,status);
        this.status=status;
        this.message=message;
    }
    private R(HttpStatus status, T data){
        super(data,status);
        this.status=status;
        this.message = status.toString();
        this.data=data;
    }
    private R(HttpStatus status, String message, T data){
        super(data,status);
        this.status=status;
        this.message=message;
        this.data=data;
    }


    public static <T> R<T> ok(T data){
        return new R<>(HttpStatus.OK, data);
    }
    public static <T> R<T> ok(String message,T data){
        return new R<>(HttpStatus.OK,message,data);
    }
    public static <T> R<T> ok(String message){
        return new R<>(HttpStatus.OK,message);
    }
    public static <T> R<T> error(){
        return new R<>(HttpStatus.BAD_REQUEST);
    }
    public static <T> R<T> error(String message){
        return new R<>(HttpStatus.BAD_REQUEST,message);
    }
    public static <T> R<T> error(HttpStatus status,String message){
        return new R<>(status,message);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
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
