package top.fengleifeng.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-09-02 15:44
 **/
public class Num219存在重复元素II {

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            for (int i = 0; i < nums.length - 1; i++) {
                int min = Math.min(nums.length, i + k + 1);
                for (int j = i + 1; j < min; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 用散列表查询
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate2(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i-k]);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 1};
        int k = 3;
        boolean b = new Num219存在重复元素II().new Solution().containsNearbyDuplicate(ints, k);
        System.out.println(b);
    }
}
