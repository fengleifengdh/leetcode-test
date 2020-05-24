package top.fengleifeng.总结.二分查找;

public class 寻找左侧边界或者右侧边界 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8};
//        System.out.println(binarySearch(integers, -1));
//        System.out.println(binarySearch2(integers, -1));
        System.out.println(binarySearchRightBorder(integers, 8));
    }

    //左侧边界
    public static Integer binarySearchRightBorder(Integer[] nums, Integer target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {//跳出条件 left >right+1  可能会越界
            int mid = left + (right - left) / 2;
            Integer now = nums[mid];
            if (now == target) {
                //搜索区间 [mid+1,right] 收缩左侧边界
                left = mid + 1;
            } else if (now < target) {
                //搜索区间 [mid+1,right]
                left = mid + 1;
            } else if (now > target) {
                //搜索区间 [left,mid-1]
                right = mid - 1;
            }
        }
//        if (left == length && nums[left-1] ==target) {
//            return left-1;
//        }
//
//        return left;
        if(right<0||nums[right]!=target){
            return -1;
        }
        return right;
    }

    //左侧边界
    public static Integer binarySearch2(Integer[] nums, Integer target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {//跳出条件 left >right+1  可能会越界
            int mid = left + (right - left) / 2;
            Integer now = nums[mid];
            if (now < target) {
                //搜索区间 [mid+1,right]
                left = mid + 1;
            } else if (now == target) {
                //搜索区间 [left,mid-1] 收缩左侧边界
                right = mid - 1;
            } else {
                //搜索区间 [left,mid-1]
                right = mid - 1;
            }
        }
        if (left == length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    //左侧边界
    public static Integer binarySearch(Integer[] nums, Integer target) {
        int length = nums.length;
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (right + left) / 2;
            Integer now = nums[mid];
            if (now < target) {
                left = mid + 1;
            } else if (now == target) {
                right = mid;
            } else {
                right = mid;
            }
        }
        if (left == length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }
}
