package com.yemu.mallrecommend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/13
 * col 列序号
 * row 行序号
 * value 存储的值
 */
public class MyMatrix<T> {
    T col;
    T row;
    List<Object> value;
    MyMatrix (T col,T row){

    }
    public Object getValue(T col,T row){
        return value;
    }
}
