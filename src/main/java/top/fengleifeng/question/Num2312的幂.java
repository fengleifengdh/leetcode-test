package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-09-04 10:24
 **/
public class Num2312的幂 {

    class Solution {
        public boolean isPowerOfTwo2(int n) {
            if (n <= 0) {
                return false;
            }
            String s = Integer.toBinaryString(n);
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    continue;
                }
                if (s.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        }

        public boolean isPowerOfTwo3(int n) {
            if (n <= 0) {
                return false;
            }
            int yushu = n % 2;
            n = n / 2;
            while (n > 0) {
                if (yushu >= 1) {
                    return false;
                }
                if (n == 0) {
                    return true;
                }
                yushu = n % 2;
                n = n / 2;

            }
            return true;
        }

        //第三种位运算
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

    public static void main(String[] args) {
        boolean powerOfTwo = new Num2312的幂().new Solution().isPowerOfTwo(2);
        System.out.println(powerOfTwo);
    }
}
