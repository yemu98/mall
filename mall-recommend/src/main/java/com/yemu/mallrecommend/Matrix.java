package com.yemu.mallrecommend;

/**
 * @author yemuc
 * @date 2020/4/4
 */
public class Matrix {

}
class MatrixItem {
    public MatrixItem(int row,int col,double value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
    private int row;
    private int col;
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
