package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-24 17:14
 **/
public class Num35搜索插入位置 {
    //二分查找
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;
//
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//                Integer now = nums[mid];
//                if (now < target) {
//                    left = mid + 1;
//                } else if (now == target) {
//                    return mid;
//                } else {
//                    right = mid - 1;
//                }
//            }
            //如果没找到
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid < target) {
                    left = mid+1;
                } else if (mid == target) {
                    return mid;
                } else {
                    right = mid-1;
                }
            }
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 6};
        int target = 0;
        int i = new Num35搜索插入位置().new Solution().searchInsert(ints, target);
        System.out.println(i);
    }
}
