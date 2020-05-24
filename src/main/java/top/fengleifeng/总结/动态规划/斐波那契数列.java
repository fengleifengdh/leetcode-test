package top.fengleifeng.总结.动态规划;

import java.util.HashMap;

public class 斐波那契数列 {

    public static void main(String[] args) {
        hashMap.put(1, 1);
        hashMap.put(2, 1);

        System.out.println(geti(4));
        System.out.println(geti1(4));
        System.out.println(geti2(4));
    }

    //优化
    public static int geti2(Integer i) {
//        int[] dp = new int[i + 1];
//        dp[1] = dp[2] = 1;
        int one = 1;
        int two = 1;
        int three = 0;
        for (int j = 3; j <=i; j++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }

    public static int geti1(Integer i) {
        int[] dp = new int[i + 1];
        dp[1] = dp[2] = 1;

        for (int j = 2; j <= i; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[i];
    }

    static HashMap<Integer, Integer> hashMap = new HashMap();

    public static Integer geti(Integer i) {
        if (i <= 2) {
            return 1;
        }
        if (hashMap.containsKey(i)) {
            return hashMap.get(i);
        } else {
            return geti(i - 1) + geti(i - 2);
        }
    }
}
