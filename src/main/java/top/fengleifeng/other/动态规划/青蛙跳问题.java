package top.fengleifeng.other.动态规划;

public class 青蛙跳问题 {

    //确定状态
    //转移方程
    //边界情况，初始条件
    //计算顺序
    public static void main(String[] args) {
//        int
//        System.out.println(soluation(5,5));
    }

    public static boolean soluation(int[] a) {

        int n = a.length;
        boolean f[] = new boolean[n ];
        f[0] = true;

        for (int i = 1; i < n; i++) {
            f[i ] = false;
            for (int j = 0; j<i; j++) {
                if(f[j] && a[j]+1>i){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}
