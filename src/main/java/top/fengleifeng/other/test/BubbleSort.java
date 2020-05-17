package top.fengleifeng.other.test;

import java.util.Arrays;

/**
 * 冒泡排序算法：
 * 顾名思义就是排序时，最大的元素会如同气泡一样移至右端，其利用比较相邻元素的方法，将大的元素交换至右端
 * 所以大的元素会不断的往右移动，直到适当的位置为止。
 * 基本的气泡排序法可以利用旗标的方式稍微减少一些比较的时间，当寻访完阵列后都没有发生任何的交换动作，表示
 * 排序已经完成，而无需再进行之后的回圈比较与交换动作。
 *
 * @author BaoZi
 * @create 2019-05-15-16:34
 */
public class BubbleSort {
    public static void main(String[] args) {
        final int MAX = 15;
        int[] nums = new int[MAX];
        System.out.println("...............使用的是冒泡排序算法...............");
        for (int i = 0; i < MAX; i++) {
            nums[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        //使用选择排序算法进行排序：
        BubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        boolean flag = true;
        //冒泡排序一共进行了nums.length-1次，因为最后一次排序之后剩下的那个元素自动就是有序的
        //外层循环控制循环的次数
        for (int i = 1; i < nums.length && flag == true; i++) {
            flag = false;
            //每次遍历都要从第一个元素开始比较
            //内层循环控制每一趟比较排序多少次
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void secondSord() {
        //冒泡排序算法
        int[] numbers=new int[]{1,5,8,2,3,9,4};
        int i,j;
        for(i=0;i<numbers.length-1;i++)
        {
            for(j=0;j<numbers.length-1-i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        System.out.println("从小到大排序后的结果是:");
        for(i=0;i<numbers.length;i++)
            System.out.print(numbers[i]+" ");
    }

}