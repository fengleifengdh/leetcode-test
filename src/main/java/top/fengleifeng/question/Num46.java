package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author: fengleifeng
 * @create: 2020-06-05 14:02
 **/
public class Num46 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        List<List<Integer>> lists = new Num46().permute(ints);
        Constants.pringtLinkedList(lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        iteration(nums, lists, new LinkedList<>());
        return lists;
    }

    public void iteration(int[] nums, List<List<Integer>> lists,List<Integer> list) {
        if(list.size()==nums.length){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            //添加
            list.add(nums[i]);
            iteration(nums, lists, list);
            list.remove(new Integer(nums[i]));
        }
    }
}
