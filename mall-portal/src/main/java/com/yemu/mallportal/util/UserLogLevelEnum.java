package com.yemu.mallportal.util;

/**
 * @author yemuc
 * @date 2020/4/29
 */
public enum UserLogLevelEnum {
    CLICK(1, "click"),
    SEARCH(2, "search"),
    ADDCART(3, "addcart"),
    BUY(-1, "buy"),
    UNLIKE(-2, "unlike");

    private final int level;
    private final String desc;

    UserLogLevelEnum(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }
}
