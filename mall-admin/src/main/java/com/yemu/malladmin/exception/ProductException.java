package com.yemu.malladmin.exception;

/**
 * @author yemuc
 * @date 2020/4/3
 */
public class ProductException extends RuntimeException {
    private int status;

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException( int status, String message){
            super(message);
            this.status = status;
        }


        public int getStatus () {
            return status;
        }
    }
