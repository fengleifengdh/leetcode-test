package top.fengleifeng.other.all;

public class 二分查找 {


    public static void main(String[] args) {
        int[] nums = {1, 22, 33, 44, 55, 66, 77, 88, 99, 120, 132, 154, 211};

        System.out.println(binarySearch(nums, 55));
        float a = 1142;
//        StringBuffer
        if (1142 == a) { // true
            System.out.println("true");
        }
    }


    public static int binarySearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;

        int notFind = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > key) {
                high = mid - 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }

        }
        return notFind;
    }
}
