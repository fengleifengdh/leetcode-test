package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1 {
    public static void main(String[] args) {
        int[] numOne = Arrays.copyOf(Constants.IntSortOne, Constants.IntSortOne.length);
        int[] numTwo = Arrays.copyOf(Constants.IntSortTwo, Constants.IntSortTwo.length);
        int[] numThree = new int[]{3, 2, 4};
        int[] result = new Num1().twoSum(numThree, 6);
        Constants.printArr(result);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[]{i, map.get(k)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
