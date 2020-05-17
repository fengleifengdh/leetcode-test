package top.fengleifeng.other.动态规划;

public class 最多路径 {
    //确定状态
    //子问题
    //转移方程
    //边界情况，初始条件
    public static void main(String[] args) {
//        int
        System.out.println(soluation(5, 5));
    }

    public static int soluation(int length, int width) {

        int f[][] = new int[length][width];
//        for (int i = 0; i < length; i++) {
//            f[i][0] = 1;
//        }
//        for (int i = 0; i < width; i++) {
//            f[0][i] = 1;
//        }


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {

                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {

                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[length - 1][width - 1];
    }
}
