package top.fengleifeng.总结.回溯;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-27 15:52
 **/
public class 数独 {
    public static void main(String[] args) {
        solve数独();
    }
    public static void solve数独() {
        int[][] source = new int[9][9];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                source[i][j] = 0;
            }
        }
        source[0][7] = 8;source[2][7] = 7;source[8][7] = 1;
        source[6][1] = 2;source[6][1] = 9;source[2][4] = 5;
        source[1][7] = 3;
        source[2][1] = 4;
        int i = 0, j = 0;
        Constants.printArrs(source);
        System.out.println();
        choose(source, i, j);
        Constants.printArrs(source);
    }

    /**
     * @param source
     * @param i
     * @param j
     */
    public static boolean choose(int[][] source, int i, int j) {
        if (j == source[0].length) {
            return choose(source, i + 1, 0);
        }
        if (i == source.length) {
            return true;
        }

        if (source[i][j] != 0) {
            return choose(source, i, j + 1);
        }

        for (int k = 1; k <= 9; k++) {
            if (!vaild(source, i, j, k)) {
                continue;
            }
            source[i][j] = k;
            if (choose(source, i, j + 1)) {
                return true;
            }
            source[i][j] = 0;
        }
        return false;
    }

    private static boolean vaild(int[][] board, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n)
                return false;
        }
        return true;
    }
}