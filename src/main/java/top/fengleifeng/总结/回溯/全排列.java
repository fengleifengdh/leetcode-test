package top.fengleifeng.总结.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-21 11:47
 **/
public class 全排列 {
    List<List<Integer>> res = new LinkedList<>();
//    public static  List<String> all = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LinkedList<Integer> track = new LinkedList<>();
        //数组全排列
        List<List<Integer>> l = new 全排列().permute(nums);
        System.out.println("");
    }

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public List<List<Integer>> permute(int[] nums) {
// 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
             backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

//    public void choose(String nums, StringBuilder track) {
//        if (nums.length() == track.length()) {
//            all.add(new String(track));
//        }
//        char[] chars = nums.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            //去除不合适的
//            if (track.toString().contains(chars[i] + "")) {
//                continue;
//            }
//            track.append(chars[i]);
//            //1.做选择
//            choose(nums, track);
//            //
//            track.deleteCharAt(i);
//        }
//    }


}
