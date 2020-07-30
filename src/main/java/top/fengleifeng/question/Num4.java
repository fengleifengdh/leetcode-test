package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;

public class Num4 {

    public static void main(String[] args) {
        int[] numOne = Arrays.copyOf(Constants.IntSortOne, Constants.IntSortOne.length);
        int[] numTwo = Arrays.copyOf(Constants.IntSortTwo, Constants.IntSortTwo.length);
        Constants.printArr(numOne);
        System.out.println();
        Constants.printArr(numTwo);
        Num4 num4 = new Num4();
        System.out.println(num4.findMedianSortedArrays(numOne, numTwo));

        int[] one1 = new int[]{1, 3};
        int[] two1 = new int[]{2};
        int[] one = new int[]{0, 0};
        int[] two = new int[]{0, 0};
//        System.out.println(num4.findMedianSortedArrays(one1, two1));
//        System.out.println(num4.findMedianSortedArrays(one, two));
//        System.out.println(num4.findMedianSortedArrays(numOne, numTwo));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }


//    public double ffindMedianSortedArrays1(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0)
//            return (left + right) / 2.0;
//        else
//            return right;
//
//    }

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
//            result = Double.valueOf(findMinK(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, left) + "");
//        } else {
//            double one = Double.valueOf(findMinK(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, left) + "");
//            double two = Double.valueOf(findMinK(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, right) + "");
//
//            result = (one + two) / 2;
//        }
//        return result;
//    }
//
//    public static double findMinK(int[] a, int lowA, int highA, int[] b, int lowB, int highB, int k) {
//
//        int len1 = highA - lowA + 1;
//        int len2 = highB - lowB + 1;
//
//        if (len1 > len2) {
//            return findMinK(b, lowB, highB, a, lowA, highA, k);
//        }
//        if (len1 == 0) {
//            return (double)b[lowB+k-1];
//        }
//
//        int na = Math.min(k/2, len1);
//        int nb = k-na;
//        if (a[na+lowA-1] < b[nb+lowB-1]) {
//            return findMinK(a, na+lowA, highA, b, lowB, nb+lowB-1, k-na);
//        } else if (a[na+lowA-1] == b[nb+lowB-1]) {
//            return (double)a[na+lowA-1];
//        } else {
//            return findMinK(b, nb+lowB, highB, a, lowA, na+lowA-1, k-nb);
//        }
//
//    }


    /**
     * 找第k个数
     *
     * @return
     */
//    public int findNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//
//        if (start1 == nums1.length) {
//            return nums2[start2 + k];
//        }
//        if (start2 == nums2.length) {
//            return nums1[start1 + k];
//        }
//        if (k <= 1) {
//            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
//        }
//        int step = k / 2;
//        int comp1 = (start1 + step) >= nums1.length ? nums1.length - 1 : (start1 + step);
//        int comp2 = (start2 + step) >= nums2.length ? nums2.length - 1 : (start2 + step);
//        if (nums1[comp1] < nums2[comp2]) {
//            if (comp1 + 1 >= nums1.length) {
//                return findNum(nums1, nums1.length, end1, nums2, start2, end2, k - (end1 - start1 + 1));
//            } else {
//                return findNum(nums1, comp1 + 1, end1, nums2, start2, end2, k - (comp1 - start1 + 1));
//            }
//        } else {
//            if (comp2 + 1 >= nums2.length) {
//                return findNum(nums1, start1, end1, nums2, nums2.length, end2, k - (end2 - start2 + 1));
//            } else {
//                return findNum(nums1, start1, end1, nums2, comp1 + 1, end2, k - (comp1 - start2 + 1));
//            }
//        }
//    }

}
