package top.fengleifeng.other.test;

import java.util.Arrays;

/**
 * 合并排序：合并排序，顾名思义，就是通过将两个有序的序列合并为一个大的有序的序列的方式来实现排序。合并排序
 * 是一种典型的分治算法：首先将序列分为两部分，然后对每一部分进行循环递归的排序，然后逐个将结果进行合并。
 *
 * @author BaoZi
 * @create 2019-05-15-18:16
 */
public class MergeSort {
    public static void main(String[] args) {
        final int MAX =15;
        int[] nums = new int[MAX];
        System.out.println("...............使用的是归并排序算法...............");
        for (int i = 0; i < MAX; i++) {
            nums[MAX - i - 1] = i + 1;
        }
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        //使用归并排序算法进行排序：
        MergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        //temp数组是一个临时数组
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(nums, left, mid, temp);
            //右边归并排序，使得右子序列有序
            sort(nums, mid + 1, right, temp);
            //将两个有序子数组合并操作
            merge(nums, left, mid, right, temp);
        }
    }
    //将nums[left...mid]和nums[mid+1....right]两部分进行归并
    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {

        //左序列开始指针
        int i = left;
        //右序列开始指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;
        //while循环将nums[left...mid]和nums[mid+1....right]中[left...mid]部分的元素或者
        // nums[mid+1....right]部分的元素逐一存入temp数组中
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        //while循环结束可能是nums[left...mid]中的元素还有剩余，这种情况下需要单独存入临时数组temp中
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        //while循环结束可能是nums[mid+1....right]中的元素还有剩余，这种情况下需要单独存入临时数组temp中
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        //重新赋值t为0，然后把临时数组temp中的元素复制到原数组nums中
        t = 0;
        //nums[left...mid]和nums[mid+1....right]合并之后存入了temp数组中，
        // 现在需要将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}