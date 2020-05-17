package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;

public class Num4 {

    public static void main(String[] args) {
        int[] numOne = Arrays.copyOf(Constants.IntSortOne, Constants.IntSortOne.length);
        int[] numTwo = Arrays.copyOf(Constants.IntSortTwo, Constants.IntSortTwo.length);
        Num4 num4 = new Num4();
        num4.findMedianSortedArrays(numOne, numTwo);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double result = null;

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int sum = nums1Length + nums2Length;
        // 如果左右相等 说明为基数 否则为偶数 ，需要找到下标为left 和right的数
        int left = (sum + 1) / 2;
        int right = (sum + 2) / 2;
        if (left == right) {
            result = Double.valueOf(findNum(nums1, 0, nums2, 0, left) + "");
        } else {
            double one = Double.valueOf(findNum(nums1, 0, nums2, 0, left) + "");
            double two = Double.valueOf(findNum(nums1, 0, nums2, 0, right) + "");
            result = (one + two) / 2;
        }
        return result;
    }

    /**
     * 找第k个数
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    public int findNum(int[] nums1, int i, int[] nums2, int j, int k) {
        int temp1 = i;
        int temp2 = j;

        int step = k / 3;//步距
        int sum = 0;
        while (sum != k) {
            if (nums1[temp1] < nums2[temp2]) {
                sum = temp1 + sum;
                if(step == k){
                    return nums1[temp1];
                }
                temp1 = temp1 + step;
            } else {
                sum = temp2 + sum;
                if(step == k){
                    return nums2[temp2];
                }
                temp2 = temp2 + step;
            }
            if (step / 2 > 0) {
                step = step / 2;
            }
        }
        return -1;
    }

}
