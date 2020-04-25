package com.yemu.malladmin.exception;

/**
 * @author yemuc
 * @date 2020/4/25
 */
public class CarouselException extends RuntimeException{
    private int status;
    public CarouselException() {
        super();
    }

    public CarouselException(String message) {
        super(message);
    }

    public CarouselException( int status, String message){
        super(message);
        this.status = status;
    }


    public int getStatus () {
        return status;
    }
}
