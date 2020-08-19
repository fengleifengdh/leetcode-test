package top.fengleifeng.总结.动态规划;

import static top.fengleifeng.总结.动态规划.凑零钱.getCoins;

public class 凑零钱多少种状态 {

    public static void main(String[] args) {

        Integer[] i = {1, 2, 5};
        Integer target = 3;
        Integer result = get(i, target);
        System.out.println(result);
    }

    //dp[i] 表示 第i块钱最少要多少银币
    public static Integer get(Integer[] arr, Integer target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 0;
        int count = 1;
        for (int i = 1; i <= target; i++) {
            int k = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j] && dp[i - arr[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - arr[j]] + 1, dp[i]);
                    k++;
                }
            }
            count = count * k;
        }
        System.out.println(count);
        return dp[target];
    }
}
