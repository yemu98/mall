package com.yemu.mallrecommend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.util.*;

/**
 * @author yemuc
 * @date 2020/4/5
 */
public class ItemCf {
    /**
     * uid/pid 1 2 3 4 5
     * 1      1 1 0 1 0
     * 2      0 1 1 0 1
     * 3      0 0 1 1 0
     * 4      0 1 1 1 0
     * 5      1 0 0 1 0
     * uid    pid
     * 1:1,2,4
     * 2:2,3,5
     * 3:3,4
     * 4:2,3,4
     * 5:1,4
     */
    static List<Data> data = new ArrayList<>();
    static double[][] sim = new double[5][5];
    static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mall?serverTimezone=UTC", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        data.add(new Data(1, 1));
        data.add(new Data(1, 2));
        data.add(new Data(1, 4));
        data.add(new Data(2, 2));
        data.add(new Data(2, 3));
        data.add(new Data(2, 5));
        data.add(new Data(3, 3));
        data.add(new Data(3, 4));
        data.add(new Data(4, 2));
        data.add(new Data(4, 3));
        data.add(new Data(4, 4));
        data.add(new Data(5, 1));
        data.add(new Data(5, 4));
//        itemSimilarity(data);
//        getSuggestion(data,1);
        List<Data> readData = readFromDb(500);
        similarity(readData);
    }

    static void similarity(List<Data> dataList) {
        System.out.println("正在进行计算。。。");
        // 保存物品pid
        Set<Integer> itemSet = new HashSet<>(16);
        // 统计物品购买次数,pid:count
        Map<Integer, Integer> itemBuyCount = new HashMap<>(16);

        // 用户-物品倒排表,uid:List<pid>
        Map<Integer, List<Integer>> userWithItem = new HashMap<>(16);
        // 进行一次遍历，统计物品购买次数、保存物品pid
        System.out.println("正在建立用户-物品倒排表。。。");
        for (Data data : dataList) {
            itemSet.add(data.pid);
            // 物品购买次数集合中没有此数据，则新建
            if (!itemBuyCount.containsKey(data.pid)) {
                itemBuyCount.put(data.pid, 1);
            } else {
                // 有此数据，购买次数加一
                itemBuyCount.put(data.pid, itemBuyCount.get(data.pid) + 1);
            }
            // 构建用户-物品倒排表
            List<Integer> pidList;
            if (!userWithItem.containsKey(data.uid)) {
                pidList = new ArrayList<>();
            } else {
                pidList = userWithItem.get(data.uid);
            }
            pidList.add(data.pid);
            userWithItem.put(data.uid, pidList);

        }
        System.out.println("倒排表建立完成");
        // 建立物品相似矩阵
        double[][] matrix = new double[itemSet.size()][itemSet.size()];
        // 保存矩阵下标和物品pid的对应关系,pid:label
        Map<Integer, Integer> pidWithMatrix = new HashMap<>(16);
        // 保存物品pid和矩阵下标对应关系，label:pid
        Map<Integer, Integer> matrixWithPid = new HashMap<>(16);
        // 物品相似度列表
        SimList simList = new SimList();
        int label = 0;
        for (Integer pid : itemSet) {
            pidWithMatrix.put(pid, label);
            matrixWithPid.put(label, pid);
            label++;
        }
        // 建立物品共现矩阵
        System.out.println("建立物品共现矩阵。。。");
        for (Integer uid : userWithItem.keySet()) {
            List<Integer> pidList = userWithItem.get(uid);
            for (int i = 0; i < pidList.size() - 1; i++) {
                for (int j = i + 1; j < pidList.size(); j++) {
                    int pid1 = pidList.get(i);
                    int pid2 = pidList.get(j);
                    matrix[pidWithMatrix.get(pid1)][pidWithMatrix.get(pid2)]++;
                    matrix[pidWithMatrix.get(pid2)][pidWithMatrix.get(pid2)]++;
                    // 同时喜欢pid1和pid2的用户数除以（喜欢pid1的用户数乘喜欢pid2的用户数）的开平方
                    double score = matrix[pidWithMatrix.get(pid1)][pidWithMatrix.get(pid2)] / Math.sqrt(itemBuyCount.get(pid1) * itemBuyCount.get(pid2));
                    if (score != 1) {
                        write(pid1, pid2, score);

                        writeToDb(pid1, pid2, score, connection);
                        simList.add(new SimList.SimItem(pid1, pid2, score));
                    }

                }
            }
        }
        // 处理共现矩阵，计算相似度
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] / Math.sqrt(itemBuyCount.get(matrixWithPid.get(i)) * itemBuyCount.get(matrixWithPid.get(j)));
            }
        }
        System.out.println("共现矩阵如下");
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(doubles[j] + ",");
            }
            System.out.println();
        }
        System.out.println("相似度结果");
//        for (SimList.SimItem simItem : simList.simItemList) {
//            System.out.println(simItem.pid1 + "和" + simItem.pid2 + "的相似度：" + simItem.score);
//        }
        System.out.println("输入要查询的相似度：");
        Scanner scanner = new Scanner(System.in);
        int pid = scanner.nextInt();
        List<SimList.SimItem> simItems = simList.findByPid(pid);
        // 根据相似度排序
        simItems.sort(Comparator.comparingDouble(SimList.SimItem::getScore).reversed());
        for (SimList.SimItem simItem : simItems) {
            System.out.println(simItem.pid1 + "和" + simItem.pid2 + "的相似度：" + simItem.score);
        }
        System.out.println("输入要查询的pid1：");
        int pid1 = scanner.nextInt();
        System.out.println("输入要查询的pid2：");
        int pid2 = scanner.nextInt();
        simItems = simList.findByPid1Pid2(pid1, pid2);
        for (SimList.SimItem simItem : simItems) {
            System.out.println(simItem.pid1 + "和" + simItem.pid2 + "的相似度：" + simItem.score);
        }

        // topN

    }

    public static List<Data> read() {
        List<Data> dataList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ratings.csv"));
            reader.readLine();
            String line;
            int count = 0;
            int userCount = 0;
            int nowUser = 0;
            System.out.println("正在读取数据。。。");
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                int uid = Integer.parseInt(item[0]);
                int pid = Integer.parseInt(item[1]);
                // 截取同一用户50条数据，为了减少矩阵大小
                if (uid == nowUser) {
                    userCount++;
                    if (userCount > 50) {
                        continue;
                    }
                } else {
                    nowUser = uid;
                    userCount = 0;
                }
                Data data = new Data(uid, pid);
//                data.setGrade((int) Double.parseDouble(item[2]));
                dataList.add(data);
                if (count++ > 5000) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("读取完成");
        return dataList;
    }

    static public void write(int pid1, int pid2, double score) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("recommend.csv", true));
            bufferedWriter.append(String.valueOf(pid1)).append(",").append(String.valueOf(pid2)).append(",").append(String.valueOf(score));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从数据库中读取数据
     */
    public static List<Data> readFromDb(int num) {
        Set<Data> dataSet = new HashSet<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mall?serverTimezone=UTC", "root", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select uid,pid,level from user_log");
            int count = 0;
            System.out.println("正在读取数据。。。");
            while (resultSet.next() && count++ < num) {
                int uid = resultSet.getInt("uid");
                int pid = resultSet.getInt("pid");
                int level = resultSet.getInt("level");
                Data data = new Data(uid, pid, level);
                dataSet.add(data);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        return new ArrayList<>(dataSet);
    }


    /**
     * 写入到数据库
     */
    static public void writeToDb(int pid1, int pid2, double score, Connection connection) {
        try {
            if (pid1 == pid2) {
                return;
            }
            PreparedStatement pst = connection.prepareStatement("insert into item_similarity values(?,?,?)");
            pst.setInt(1, pid1);
            pst.setInt(2, pid2);
            pst.setDouble(3, score);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                PreparedStatement pst = connection.prepareStatement("update item_similarity set similarity=? where pid1=? and pid2=?");
                pst.setDouble(1, score);
                pst.setInt(2, pid1);
                pst.setInt(3, pid2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    static class Data {
        int uid;
        int pid;
        double grade;

        Data(int uid, int pid) {
            this.uid = uid;
            this.pid = pid;
        }

        Data(int uid, int pid, double grade) {
            this.uid = uid;
            this.pid = pid;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }
    }


    /**
     * 用户喜好基本数据类型
     */
    static class UserData {
        int uid;
        int pid;
        int level;

        UserData(int uid, int pid) {
            this.uid = uid;
            this.pid = pid;
        }

        UserData(int uid, int pid, int level) {
            this.uid = uid;
            this.pid = pid;
            this.level = level;
        }
    }

    /**
     * 推荐基本数据类型
     */
    static class Suggestion {
        int basePid;
        int pid;
        double score;

        Suggestion(int basePid, int pid, double score) {
            this.basePid = basePid;
            this.pid = pid;
            this.score = score;
        }
    }

    /**
     * 物品相似度
     */
    static class SimList {
        List<SimItem> simItemList;

        SimList() {
            this.simItemList = new ArrayList<>();
        }

        public List<SimItem> add(SimItem simItem) {
            if (containItem(simItem) < 0) {
                simItemList.add(simItem);
            } else {
                simItemList.set(containItem(simItem), simItem);
            }
            return simItemList;
        }

        public List<SimItem> findByPid(int pid) {
            List<SimItem> simItems = new ArrayList<>();
            for (SimItem simItem : simItemList) {
                if (simItem.pid1 == pid) {
                    simItems.add(simItem);
                }
            }
            return simItems;
        }

        public List<SimItem> findByPid1Pid2(int pid1, int pid2) {
            List<SimItem> simItems = new ArrayList<>();
            for (SimItem simItem : simItemList) {
                if (simItem.pid1 == pid1 && simItem.pid2 == pid2) {
                    simItems.add(simItem);
                }
                if (simItem.pid2 == pid1 && simItem.pid1 == pid1) {
                    simItems.add(simItem);
                }
            }
            return simItems;
        }

        public int containItem(SimItem simItem) {
            for (int i = 0; i < simItemList.size(); i++) {
                SimItem simItem1 = simItemList.get(i);
                if ((simItem1.pid1 == simItem.pid1 && simItem1.pid2 == simItem.pid2) || (simItem1.pid2 == simItem.pid1 && simItem1.pid1 == simItem.pid2)) {
                    return i;
                }
            }
            return -1;
        }

        public List<SimItem> getSimItemList() {
            return simItemList;
        }

        public void setSimItemList(List<SimItem> simItemList) {
            this.simItemList = simItemList;
        }

        static class SimItem {
            int pid1;
            int pid2;
            double score;

            public SimItem(int pid1, int pid2, double score) {
                this.pid1 = pid1;
                this.pid2 = pid2;
                this.score = score;
            }

            public double getScore() {
                return score;
            }
        }


    }

}
