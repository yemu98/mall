package com.yemu.mallrecommend;

import com.yemu.mallrecommend.MatrixItem;
import com.yemu.mallrecommend.ReadCsv;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /***
         * 数据集
         * uid,pid,grade,type,timeStamp
         */
//        List<Data> dataList = new ArrayList<>();
//        dataList.add(new Data(1, 1001, 3));
//        dataList.add(new Data(2, 1001, 4));
//        dataList.add(new Data(3, 1001, 3));
//        dataList.add(new Data(4, 1001, 3));
//        dataList.add(new Data(1, 1002, 3));
//        dataList.add(new Data(4, 1002, 4));
//        dataList.add(new Data(1, 1003, 4));
//        dataList.add(new Data(3, 1003, 5));
//        dataList.add(new Data(4, 1003, 5));
//        dataList.add(new Data(1, 1004, 4));
//        dataList.add(new Data(3, 1004, 3));
//        dataList.add(new Data(1, 1005, 5));

        /****
         * 喜好表
         *   A B C D E
         * a 1 1 0 1 0
         * b 1,0,1,0,0
         * c 0,1,0,0,1
         * d 0,0,1,1,1
         */
        // 用户到物品喜好表
//        int[] a = {1, 1, 0, 1, 0};
//        int[] b = {1, 0, 1, 0, 0};
//        int[] c = {0, 1, 0, 0, 1};
//        int[] d = {0, 0, 1, 1, 1};
//        // 物品到用户的倒排表
//        int[] A = {1, 1, 0, 0};
//        int[] B = {1, 0, 1, 0};
//        int[] C = {0, 1, 0, 1};
//        int[] D = {1, 0, 0, 1};
//        int[] E = {0, 0, 1, 1};
        // 用户相似度矩阵
//        double[][] W = new double[4][4];
//        long startTime = System.currentTimeMillis();
//        System.out.println(cosineSimilarity(a, d));
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime) + "ms");
//        long startTime = System.currentTimeMillis();
//        getW(W, A);
//        getW(W, B);
//        getW(W, C);
//        getW(W, D);
//        getW(W, E);
//
//        userSimilarity(W);
//        for (int i = 0; i < W.length; i++) {
//            for (int j = 0; j < W[0].length; j++) {
//                System.out.print(W[i][j] + " ");
//            }
//            System.out.println();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime) + "ms");

        List<Data> dataList = ReadCsv.read();
        List<LikeItem> like = userCf(dataList, 1);

        for (LikeItem likeItem : like) {
            System.out.println(likeItem.pid + " " + likeItem.level);
        }
    }

    static List<LikeItem> userCf(List<Data> dataList, int uid) {
        // 建立物品到用户倒排表
        Map<Integer, List<Integer>> itemToUser = new HashMap<>(16);
        for (Data data : dataList) {
            if (!itemToUser.containsKey(data.getPid())) {
                itemToUser.put(data.getPid(), new ArrayList<>());
            }
            itemToUser.get(data.getPid()).add(data.getUid());
        }

        // 构建用户相似矩阵
        List<MatrixItem> matrixItems = new ArrayList<>();
        for (int pid : itemToUser.keySet()) {
            List<Integer> uids = itemToUser.get(pid);
            for (int i = 0; i < uids.size() - 1; i++) {
                for (int j = i + 1; j < uids.size(); j++) {
                    matrixItems.add(new MatrixItem(uids.get(i), uids.get(j), 1));
                    matrixItems.add((new MatrixItem(uids.get(j), uids.get(i), 1)));
                }
            }
        }
        for (MatrixItem matrixItem : matrixItems) {
            matrixItem.setValue(
                    matrixItem.getValue() / Math.sqrt(
                            getItemCountByUid(dataList, matrixItem.getRow()) * getItemCountByUid(dataList, matrixItem.getCol())
                    ));
        }


        // 从相似矩阵中找到与目标用户最相似的k个用户
        // 对集合降序排列
        Collections.sort(matrixItems, new Comparator<MatrixItem>() {
            @Override
            public int compare(MatrixItem o1, MatrixItem o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return -1;
            }
        });
        // 相似用户id列表 获取k个用户的id
        int k = 20;
        List<Integer> simUidList = new ArrayList<>();
        for (MatrixItem matrixItem : matrixItems) {
            if (matrixItem.getRow() == uid && k > 0) {
                simUidList.add(matrixItem.getCol());
                k--;
            }
        }
        // 计算用户可能感兴趣的商品
        Set<Integer> pidSet = new HashSet<>(16);
        for (Data data : dataList) {
            if (simUidList.contains(data.getUid())) {
                pidSet.add(data.getPid());
            }
        }
        // 过滤已感兴趣的内容
        for (Data data : dataList) {
            if (uid == data.getUid()) {
                pidSet.remove(data.getPid());
            }
        }
        // 预测候选物品的感兴趣程度
        List<LikeItem> likeItemList = new ArrayList<>();
        for (int pid : pidSet) {
            LikeItem likeItem = new LikeItem();
            likeItem.pid = pid;
            likeItem.level = 0;
            for (int uid2 : itemToUser.get(pid)) {
                if (uid2 != uid) {
                    for (MatrixItem matrixItem : matrixItems) {
                        if (matrixItem.getRow() == uid && matrixItem.getCol() == uid2) {
                            likeItem.level += matrixItem.getValue()*getGrade(dataList,uid2,pid);
                        }
                    }
                }
            }
            likeItemList.add(likeItem);
        }

        // 排序
        Collections.sort(likeItemList, new Comparator<LikeItem>() {
            @Override
            public int compare(LikeItem o1, LikeItem o2) {
                if (o1.level < o2.level) {
                    return 1;
                }
                return -1;
            }
        });

        return likeItemList;
    }

    static double getGrade(List<Data> dataList,int uid,int pid){
        for(Data data:dataList){
            if (data.getUid()==uid&&data.getPid()==pid){
                return data.getGrade();
            }
        }
        return 1;
    }



    static int getItemCountByUid(List<Data> dataList, int uid) {
        int sum = 0;
        for (Data data : dataList) {
            if (data.getUid() == uid) {
                sum++;
            }
        }
        return sum;
    }

    static void getW(double[][] w, int[] item) {
        for (int i = 0; i < item.length - 1; i++) {
            if (item[i] == 1) {
                for (int j = i + 1; j < item.length; j++) {
                    if (item[j] == 1) {
                        w[i][j] += 1;
                        w[j][i] += 1;
                    }
                }
            }
        }
    }

    /**
     * 计算用户相似度
     */
    static void userSimilarity(double[][] w) {

        for (int i = 0; i < w.length; i++) {

            for (int j = 0; j < w[0].length; j++) {
                double s1 = 0;
                double s2 = 0;
                for (int r = 0; r < w.length; r++) {
                    if (w[i][r] != 0) {
                        s1++;
                    }
                    if (w[r][j] != 0) {
                        s2++;
                    }
                }
                w[i][j] = w[i][j] / Math.sqrt(s1 * s2);
            }
        }
    }

    /**
     * 余弦相似度计算
     *
     * @param a
     * @param b
     * @return
     */
    static double cosineSimilarity(int[] a, int[] b) {
        double sim = 0;
        int s1 = 0;
        double s2 = 0;
        double s3 = 0;
        for (int i = 0; i < a.length; i++) {
            // x(i)*y(i)累加
            s1 += a[i] * b[i];
            // x(i)*x(i)累加
            s2 += a[i] * a[i];
            // y(i)*y(i)累加
            s3 += b[i] * b[i];
        }
        // 开平方
        s2 = Math.sqrt(s2);
        s3 = Math.sqrt(s3);
        double s4 = s2 * s3;
        // 计算
        sim = s1 / s4;
        return sim;
    }

}
