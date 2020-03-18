package com.yemu.mallportal.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




public class R<T> extends ResponseEntity<T> {


    private R(HttpStatus status,PlayLoad playLoad){
        super((T) playLoad,status);
    }


    public static <T> R<T> ok(T data){
        PlayLoad<T> playLoad = new PlayLoad<>(HttpStatus.OK.value(),HttpStatus.OK.toString(),data);
        return new R<>(HttpStatus.OK, playLoad);
    }
    public static <T> R<T> ok(String message,T data){
        PlayLoad<T> playLoad = new PlayLoad<>(HttpStatus.OK.value(),message,data);
        return new R<>(HttpStatus.OK, playLoad);
    }
    public static <T> R<T> ok(String message){
        PlayLoad<T> playLoad = new PlayLoad<>(HttpStatus.OK.value(),message,null);
        return new R<>(HttpStatus.OK, playLoad);
    }
    public static <T> R<T> error(){
        PlayLoad<T> playLoad = new PlayLoad<>(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.toString(),null);
        return new R<>(HttpStatus.BAD_REQUEST, playLoad);
    }
    public static <T> R<T> error(String message){
        PlayLoad<T> playLoad = new PlayLoad<>(HttpStatus.BAD_REQUEST.value(),message,null);
        return new R<>(HttpStatus.BAD_REQUEST, playLoad);
    }
    public static <T> R<T> error(HttpStatus status,String message){
        PlayLoad<T> playLoad = new PlayLoad<>(status.value(),message,null);
        return new R<>(status, playLoad);
    }





    private static class PlayLoad<T>{
        int status;
        String message;
        T data;

        PlayLoad(int status,String message,T data){
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
