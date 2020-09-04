package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 通过次数95,312提交次数144,696
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-04 15:20
 **/
public class Num287寻找重复数 {
//
//    class Solution {
//        public int findDuplicate(int[] nums) {
//            int countFast = 0;
//            int countSlow = 0;
//            while (true) {
//                if (countFast != countSlow && nums[countFast] == nums[countSlow]) {
//                    return nums[countFast];
//                } else {
//                    countFast = check(nums.length, countFast + 2);
//                    countSlow = check(nums.length, countSlow + 1);
//                }
//            }
//        }
//
//        public int check(int length, int num) {
//            if (num >= length) {
//                num = num - length;
//            }
//            return num;
//        }
//    }
//
//    public static void main(String[] args) {
////        int[] ints = {1, 3, 4, 2, 2};
//        int[] ints = {3,1,3,4,2};
//        int i = new Num287寻找重复数().new Solution().findDuplicate(ints);
//        System.out.println(i);
//    }
}
