package top.fengleifeng.question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-24 19:56
 **/
public class Num15三数之和 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            int length = nums.length;
            Arrays.sort(nums);
            for (int first = 0; first < length; first++) {
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }

                int target = -nums[first];

                int third = length - 1;
                for (int second = first + 1; second < third; ++second) {
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> one = new LinkedList<>();
                        one.add(nums[first]);
                        one.add(nums[second]);
                        one.add(nums[third]);
                        result.add(one);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        new Num15三数之和().new Solution().threeSum(ints);
    }
}
