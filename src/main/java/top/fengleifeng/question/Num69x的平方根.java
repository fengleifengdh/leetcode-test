package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 通过次数194,905提交次数501,974
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-26 17:44
 **/
public class Num69x的平方根 {
    /**
     * 思路找到count
     */
    class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        public int mySqrt2(int x) {
            if(x==0){
                return 0;
            }
            int left = 0, right = x, ans = 0;
            while (left <= right) {
                ans = left + (right - left) / 2;
                if((ans > 0 || ((ans - 1) * (ans - 1) < x)) && ((ans + 1) * (ans + 1) > x)
                        && (ans * ans <= x)){
                    return ans;
                }
                if (ans * ans < x) {
                    left = ans + 1;
                } else {
                    right = ans - 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        System.out.println(1/2);
        int x = 2147395599;
        int i = new Num69x的平方根().new Solution().mySqrt2(x);
        System.out.println(i);
    }
}
