package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-19 19:25
 **/
public class Num41缺失的第一个正数 {
    class Solution {
        public int firstMissingPositive(int[] nums) {

            int count = 0;
            int length = nums.length;
            if(length==0){
                return 1;
            }
            while (count < length) {
                int now = nums[count];
                if (now > length || now <= 0) {
                    nums[count] = Integer.MIN_VALUE;
                    count++;
                    continue;
                } else {
                    if ((now - 1) != count) {
                        change(nums, count, now - 1);
                    }else{
                        count++;
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                if (nums[i] == Integer.MIN_VALUE) {
                    return ++i;
                }
            }
            return length;
        }

        public void change(int[] nums, int one, int two) {
            nums[one] = nums[one] + nums[two];
            nums[two] = nums[one] - nums[two];
            nums[one] = nums[one] - nums[two];
        }
    }

    public static void main(String[] args) {
        int[] i = {1};
//        Solution solution = this.new Solution();
        int i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i);
        System.out.println(i1);
    }
}
