package top.fengleifeng.总结.二分查找;

public class 模板 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(integers, 8));
    }

    public static Integer binarySearch(Integer[] nums, Integer target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Integer now = nums[mid];
            if (now < target) {
                left = mid + 1;
            } else if (now == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }


        return null;
    }
}
