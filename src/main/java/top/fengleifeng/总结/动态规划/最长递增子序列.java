package top.fengleifeng.总结.动态规划;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 4, 2, 4, 5, 6,7};
        System.out.println(get(ints));
    }

    public static int get(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }

        return dp[nums.length - 1];
    }
}
