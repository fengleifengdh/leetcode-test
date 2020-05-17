public class Tes {
    public static void main(String[] args) {
        int[]   nums = {10,5,2,45,61,24,1234,5,12,1,4,51,24,1};
        final int MAX = nums.length;
        System.out.println("...............使用的是插入排序算法...............");
//        for (int i = 0; i < MAX; i++) {
//            nums[i] = (int) (Math.random() * 10 + 5);
//        }
//        nums = {10,5,2,45,61,24,1234,5,12,1,4,51,24,1};
        System.out.println("排序之前的数组为...............");
        for (int i = 0; i < MAX; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("排序之后的数组为...............");
        //使用选择排序算法进行排序：
        insertSort(nums);
        for (int i = 0; i < MAX; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[k] = nums[j];
                    k--;
                } else {
//                    temp = nums[j];
//                    k--;
                    break;
                }
            }
            nums[k] = temp;
        }
        return nums;
    }
    public void swap(int[] num,int one,int two){
        int temp = num[one];
        num[one] = num[two];
        num[two] = temp;
    }
}
