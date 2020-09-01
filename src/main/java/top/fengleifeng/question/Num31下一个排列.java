package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;

/**
 * @program: leetcode-test
 * @description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 通过次数83,958提交次数243,898
 * @author: fengleifeng
 * @create: 2020-08-26 15:55
 **/
public class Num31下一个排列 {
    /**
     * 思路：数字由大到小排列
     * 方案：
     */
    class Solution {
        public void nextPermutation(int[] nums) {
            //i 指针在前，从后往前遍历
            for(int i = nums.length-1; i>=0; i--){
                // j指针在后
                for(int j = nums.length-1; j>i; j--){
                    if(nums[i] < nums[j]){
                        swap(nums,i,j);
                        Arrays.sort(nums,i+1,nums.length);
                        return;
                    }
                }
            }
            //如果没有找到
            Arrays.sort(nums);
        }

        void swap(int[] a, int i, int j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }



    public static void main(String[] args) {
        int[] ints = {3,2,1};//[2,1,3]
        new Num31下一个排列().new Solution().nextPermutation(ints);
        Constants.printArr(ints);
    }
}
