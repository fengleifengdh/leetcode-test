package top.fengleifeng.总结.动态规划;

public class 最少替换 {
    //
//    /
//
//      if(s1[i] == s2[j]){
//          skip;
//          i++;j++;
//      }else{
//          三选一：
//          插入：
//          删除：
//          替换：
//      }

    //
//    对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
//
//    以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
//
//            (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
//
//            (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
//
//            (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
////     /
    public static int minDistance(String s1, String s2) {

        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] dp = new int[s1Length + 1][s2Length + 1];
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();
        //初始化
        dp[0][0] = 0;
        for (int k = 1; k <= s1Length; k++) {
            dp[k][0] = dp[k - 1][0] + 1;
        }
        for (int k = 1; k <= s2Length; k++) {
            dp[0][k] = dp[0][k - 1] + 1;
        }
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (s1chars[i - 1] == s2chars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int update = dp[i - 1][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(update, del), insert);
                }
            }
        }

        return dp[s1Length][s2Length];
    }

    public static void main(String[] args) {
        String s1 = "flf";
        String s2 = "ff1";
        System.out.println(minDistance(s1,s2));
    }

}
