package com.yemu.mallportal.common;

/**
 * @author yemu
 */

public enum  ResponseCode {
    /**
     * SUCCESS 成功
     * ERROR 错误
     * UNLOGIN 未登录
     */
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    UNLOGIN(2,"UNLOGIN");
    private final int code;
    private final String desc;

     ResponseCode(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
