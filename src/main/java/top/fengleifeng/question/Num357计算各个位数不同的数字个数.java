package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * 通过次数12,468提交次数24,272
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-04 17:13
 **/
public class Num357计算各个位数不同的数字个数 {
    /**
     * 循环减枝
     */
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if(n==0){
                return 1;
            }
            boolean[] used = new boolean[10];
            int idex = 0;
            int count = count(used,n,idex);
            return count;
        }

        public int count(boolean[] used, int n, int idx) {
            int count = 0;
            if (idx != n) {
                for (int i = 0; i < 10; i++) {
                    if (i == 0 && n > 1 && idx == 1) {
                        continue;//2位数开始首字母不能为0
                    }
                    if(used[i]){
                        continue;
                    }
                    used[i] = true;
                    count += count(used,n,idx+1)+1;
                    used[i] = false;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int i = new Num357计算各个位数不同的数字个数().new Solution().countNumbersWithUniqueDigits(0);
        System.out.println(i);
    }
}
