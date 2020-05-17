package top.fengleifeng.other.动态规划;

public class 硬币问题 {
    //2,5,7   求 27元最少
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        System.out.println(soluation(arr, 27));
    }

    public static int soluation(int[] a, int num) {
        int[] f = new int[num + 1];
        int n = a.length;
        f[0] = 0;
        for (int i = 1; i <= num; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= a[j] && f[i - a[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - a[j]] + 1, f[i]);
                }
            }
        }
        return f[num];
//        if(f[num])
    }
}
