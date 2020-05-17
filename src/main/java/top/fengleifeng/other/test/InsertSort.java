package top.fengleifeng.other.test;

/**
 * 插入排序算法：
 * 将数组分为两部分，前一部分时已经有序的数组，后一部分是无序的，每次都从后边无序数组中取出最前的
 * 数据插入到前边有序的数组中，并且保证每次插入之后的数组依然是有序的
 *
 * @author BaoZi
 * @create 2019-05-15-16:09
 */
public class InsertSort {
    public static void main(String[] args) {
        final int MAX = 15;
        int[] nums = new int[MAX];
        System.out.println("...............使用的是插入排序算法...............");
        for (int i = 0; i < MAX; i++) {
            nums[i] = (int) (Math.random() * 10 + 5);
        }
        System.out.println("排序之前的数组为...............");
        for (int i = 0; i < MAX; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("排序之后的数组为...............");
        //使用选择排序算法进行排序：
        InsertSort.insertSort(nums);
        for (int i = 0; i < MAX; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void insertSort(int[] nums) {
        //插入排序算法默认的第一个元素直接就是有序的，所以第二个元素开始进行插入排序
        for (int i = 1; i < nums.length; i++) {
            int temp_num = nums[i];
            int temp_index = i - 1;
            //这个while循环用于找出当前i元素在0---i的准确位置
            while (temp_num < nums[temp_index]) {
                nums[temp_index + 1] = nums[temp_index];
                temp_index--;
                if (temp_index == -1) {
                    break;
                }
            }
            nums[temp_index + 1] = temp_num;
        }
    }
}