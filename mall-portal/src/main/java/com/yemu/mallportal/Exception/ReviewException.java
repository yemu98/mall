package com.yemu.mallportal.Exception;

/**
 * @author yemuc
 * @date 2020/3/31
 */
public class ReviewException extends RuntimeException {
    private int status;
    public ReviewException(){
        super();
    }
    public ReviewException(String message){
        super(message);
    }
    public ReviewException(int status,String message){
        super(message);
        this.status=status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
