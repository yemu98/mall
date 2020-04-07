package com.yemu.mallportal.Exception;

/**
 * @author yemuc
 * @date 2020/4/7
 */
public class LoginException extends RuntimeException {
    private int status;
    public LoginException(){
        super();
    }
    public LoginException(String message){
        super(message);
    }
    public LoginException(int status,String message){
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
