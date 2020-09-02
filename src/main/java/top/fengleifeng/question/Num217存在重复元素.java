package top.fengleifeng.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-09-02 15:40
 **/
public class Num217存在重复元素 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }
            return false;
        }
    }
}
