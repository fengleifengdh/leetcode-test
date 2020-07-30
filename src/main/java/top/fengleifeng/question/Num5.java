package top.fengleifeng.question;

import java.util.Arrays;

public class Num5 {

    public static void main(String[] args) {
        String s = "412213";
        System.out.println(new Num5().longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], false);
        }
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {

                dp[i][j] = charArray[i] == charArray[j] && (j - i < 3 || dp[i + 1][j - 1]);

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //中心扩散法
}
