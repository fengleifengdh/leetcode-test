package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *  
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-04 15:07
 **/
public class Num268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count = count + nums[i];
            }
            return (0 + nums.length) * (nums.length + 1) / 2 - count;
        }
    }

    public static void main(String[] args) {
        int[] ints= {3,0,1};
        int i = new Num268().new Solution().missingNumber(ints);
        System.out.println(i);
    }
}
