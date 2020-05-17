package top.fengleifeng.other.test;

import java.util.Arrays;

/**
 * 选择排序算法：
 * 将数组分为两部分，前边一部分时已经排序好的，后面是没有排序的，从后端未排序的部分选择一个最小值，
 * 然后放在前端已经排序部分的最后
 *
 * @author BaoZi
 * @create 2019-05-15-15:39
 */
public class SelSort {
    public static void main(String[] args) {
        final int MAX = 15;
        int[] nums = new int[MAX];
        System.out.println("...............使用的是选择排序算法...............");
        for (int i = 0; i < MAX; i++) {
            nums[i] = (int) (Math.random() * 10 + 5);
        }
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        //使用选择排序算法进行排序：
        SelSort.selSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selSort(int[] nums) {
        int length = nums.length;
        //需要进行n-1次循环比较，用于确定第0、1、2.....n-1个位置上的元素值
        for (int i = 0; i < length - 1; i++) {
            //变量temp_index用于记录当前位置的最小元素坐标，初始值赋值为i
            int temp_index = i;
            //选出当前位置之后的所有元素中最小的元素，循环结束temp_index中存放的就是当前最小元素的下标
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[temp_index]) {
                    temp_index = j;
                }
            }
            //如果最小元素的位置不是i的话，两个元素调换
            if (temp_index != i) {
                int temp_num = nums[temp_index];
                nums[temp_index] = nums[i];
                nums[i] = temp_num;
            }
        }
    }
}