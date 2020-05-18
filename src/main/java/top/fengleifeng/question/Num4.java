package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;

public class Num4 {

    public static void main(String[] args) {
        int[] numOne = Arrays.copyOf(Constants.IntSortOne, Constants.IntSortOne.length);
        int[] numTwo = Arrays.copyOf(Constants.IntSortTwo, Constants.IntSortTwo.length);

        Num4 num4 = new Num4();
//        System.out.println(num4.findMedianSortedArrays(numOne, numTwo));
        System.out.println(num4.ffindMedianSortedArrays1(numOne, numTwo));

        int[] one = new int[]{1, 3};
        int[] two = new int[]{2};
//        System.out.println(num4.findMedianSortedArrays(one, two));

    }

    public double ffindMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        Double result = null;
//
//        int nums1Length = nums1.length;
//        int nums2Length = nums2.length;
//        int sum = nums1Length + nums2Length;
//        // 如果左右相等 说明为基数 否则为偶数 ，需要找到下标为left 和right的数
//        int left = (sum + 1) / 2;
//        int right = (sum + 2) / 2;
//        if (left == right) {
//            result = Double.valueOf(findNum(nums1, nums1Length / 2, nums2, nums2Length / 2, left) + "");
//        } else {
//            double one = Double.valueOf(findNum(nums1, nums1Length / 2, nums2, nums2Length / 2, left) + "");
//            double two = Double.valueOf(findNum(nums1, nums1Length / 2, nums2, nums2Length / 2, right) + "");
//            result = (one + two) / 2;
//        }
//        return result;
//    }


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
//    public int findNum(int[] nums1, int i, int[] nums2, int j, int k) {
//        int temp1 = i, temp1Last = i + 1;
//        int temp2 = j, temp2Last = j + 1;
//
//        int step = (k / 3) > 0 ? k / 3 : 1;//步距
//        int sum = 0;
//        while (sum != k) {
//            if (nums1[temp1] < nums2[temp2]) {
//                sum = temp1Last + sum;
//
//                if (sum == k) {
//                    return nums1[temp1];
//                }
//
//                temp1 = temp1 + step;
//                temp2 = (temp2 + 1 - step) > 0 ? temp2 - step : 0;
//            } else {
//                sum = temp2Last + sum;
//                temp2 = temp2 + step;
//                temp1 = (temp1 + 1 - step) > 0 ? temp1 - step : 0;
//                if (sum == k) {
//                    return nums2[temp2];
//                }
//            }
//
//            if (step / 2 > 0) {
//                step = step / 2;
//            }
//            temp1Last = step;
//            temp2Last = step;
//        }
//        return -1;
//    }

}
