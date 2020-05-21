package top.fengleifeng.总结.回溯;

import top.fengleifeng.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-21 14:09
 **/
public class Eight皇后问题 {
    public static List<int[][]> container = null;

    public static void main(String[] args) {
        int n = 8;
        container = new ArrayList<>();

        solveNQueens(8);

        for (int i = 0; i < container.size(); i++) {
            Constants.printArrs(container.get(i));
        }
    }


    public static void solveNQueens(int n) {
        //初始化这一个路径
        int[][] one = new int[n][n];
        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[0].length; j++) {
                one[i][j] = 0;//0代表无
            }
        }
        choose(one, 0);

    }

    public static void choose(int[][] one, int n) {
        if (n == one.length) {
            container.add(Constants.copy2Arr(one));
            return;
        }
        for (int i = 0; i < one.length; i++) {
            if (!isValid(one, n, i)) {
                continue;
            }
            //1.做选择：
            one[n ][i] = 1;
            //2.choose(路径，选择列表）
            choose(one, n +1);
            //3.撤销选择
            one[n ][i] = 0;
        }

    }

    private static boolean isValid(int[][] one, int row, int col) {
        int n = one.length;
//        int row = n1 - 1;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (one[i][col] == 1) {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (one[i][j] == 1) {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (one[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
