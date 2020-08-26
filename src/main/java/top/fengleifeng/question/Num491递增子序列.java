package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * 通过次数21,474提交次数39,145
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-25 20:21
 **/
public class Num491递增子序列 {
    /**
     * 解题思路：
     * 找到每一个数字之后比自己小的数的位置，然后求子序列
     */
    class Solution {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();


        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(0, Integer.MIN_VALUE, nums);
            return ans;
        }

        void dfs(int start, int lastValue, int[] nums) {
            if (start == nums.length) {
                if (temp.size() >=2) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            if (nums[start] >= lastValue) {
                temp.add(nums[start]);
                dfs(start + 1, nums[start], nums);
                temp.remove(temp.size() - 1);
            }
            if (nums[start] != lastValue) {
                dfs(start + 1, lastValue, nums);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {4, 6, 7, 7};
        List<List<Integer>> subsequences = new Num491递增子序列().new Solution().findSubsequences(ints);
        Constants.pringLinkedLists(subsequences);

    }
}
