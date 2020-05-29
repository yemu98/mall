package com.yemu.mallrecommend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yemuc
 * @date 2020/4/4
 */
public class ReadCsv {
//    public static void main(String[] args) {
//        List<Data> dataList = read();
//        System.out.println(dataList.get(0).getPid());
//    }
    public static List<Data> read(){
        List<Data> dataList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ratings.csv"));
            reader.readLine();
            String line;
            while ((line=reader.readLine())!=null){
                String[] item = line.split(",");
                Data data = new Data();
                data.setUid(Integer.parseInt(item[0]));
                data.setPid(Integer.parseInt(item[1]));
                data.setGrade((int) Double.parseDouble(item[2]));

                dataList.add(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataList;
    }
}
