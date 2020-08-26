package top.fengleifeng.question;

import java.util.HashMap;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-26 11:02
 **/
public class Num50Pow {
    class Solution {
        public double myPow(double x, int n) {
            long nl = n;
            if (x == 0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                x = 1 / x;
                nl = -nl;
            }
            return quick2(nl, x);
        }

        double quick(long n, double x) {
            if (n == 0) {
                return 1;
            }
            double result = quick(n / 2, x);
            return n % 2 == 0 ? result * result : result * result * x;
        }

        double quick2(long n, double x) {
            double res = 1;
            double xn = x;
            while (n > 0) {
                if (n % 2 == 1) {
                    res = res * xn;
                }
                xn = xn* x;
                n = n / 2;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 3;
        double v = new Num50Pow().new Solution().myPow(x, n);
        System.out.println(v);
    }
}
