package com.yemu.mallportal.Exception;

/**
 * 生成订单异常处理类
 * @author yemuc
 * @date 2020/3/26
 */
public class OrderException extends RuntimeException {
    private int status;
    public OrderException(){
        super();
    }
    public OrderException(String message){
        super(message);
    }
    public OrderException(int staus,String message){
        super(message);
        this.status=staus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
