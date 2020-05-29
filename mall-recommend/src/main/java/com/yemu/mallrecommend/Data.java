package com.yemu.mallrecommend;

import java.sql.Timestamp;

/**
 * @author yemuc
 * @date 2020/4/4
 */
public class Data {
    private int uid;
    private int pid;
    private int grade;
    private String type = "";
    private Timestamp timestamp;
    public Data(){

    }
    public Data(int uid,int pid){
        this.uid = uid;
        this.pid = pid;
    }
    public Data(int uid,int pid,int grade){
        this.uid = uid;
        this.pid = pid;
        this.grade = grade;
    }
    public Data(int uid,int pid,String type,Timestamp timestamp){
        new Data(uid,pid);
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
