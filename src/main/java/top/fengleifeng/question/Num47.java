package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * //思路
 * [1,1,2]
 * 分为两个数组
 * [1,2] [1]
 * @author: fengleifeng
 * @create: 2020-06-05 14:16
 **/
public class Num47 {
    public static void main(String[] args) {
        int[] ints = new int[]{2,2,1,1};
        //
        List<List<Integer>> lists = new Num47().permuteUnique(ints);
        Constants.pringtLinkedList(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //创建一个数据记录
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> lists = new LinkedList<>();
        iteration(nums, lists, new LinkedList<>(), used);
        return lists;
    }

    public void iteration(int[] nums, List<List<Integer>> lists, LinkedList<Integer> list,
                          boolean[] used) {
        if (list.size() == nums.length) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //重点在这,如果数据重复，并且前一个数据已经走过的话就会跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //添加
            used[i] = true;
            list.add(nums[i]);
            iteration(nums, lists, list, used);
            used[i] = false;
            list.removeLast();
        }
    }
}
