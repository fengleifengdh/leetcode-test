package top.fengleifeng.总结.动态规划;

public class 凑零钱 {

    public static void main(String[] args) {

        Integer[] i = {1,2,5};
        Integer target = 13;
        Integer result = getCoins(i,target);
        System.out.println(result);
    }

    //dp[i] 表示 第i块钱最少要多少银币
    public static Integer getCoins(Integer[] cons, Integer target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < cons.length; j++) {
//                dp[i] = Math.min(dp[i - 1], dp[])
                if (i >= cons[j] && dp[i - cons[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - cons[j]] + 1, dp[i]);
                }
            }
        }
        return dp[target];
    }
}
