package top.fengleifeng.other.动态规划;

//最长公共子序列
public class 公共字符串 {

    public static void main(String[] args) {
        System.out.println(getStr("123456", "345129"));
    }

    public static int getStr(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        char[] str1Char = str1.toCharArray();
        char[] str1Char2 = str2.toCharArray();


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1Char[i - 1] == str1Char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
