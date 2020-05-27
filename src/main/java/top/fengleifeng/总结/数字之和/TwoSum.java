package top.fengleifeng.总结.数字之和;

import top.fengleifeng.util.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * 两数之和
 * 给定一个数组[1，5,9,2]
 * 再给定一个数  10
 * 返回[0,3]   0，3为下标
 */
public class TwoSum {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 5, 5, 10};
        Integer target = 10;
        Integer[] result = locations(integers, target);
        Integer[] result2 = integers(integers, target);
        Constants.printArr(result);
        Constants.printArr(result2);
    }

    public static Integer[] locations(Integer[] nums, Integer target) {
        Map<Integer, LinkedList<Integer>> location = new HashMap<>();
        //初始话查询
        for (int i = 0; i < nums.length; i++) {
            if (null == location.get(nums[i])) {
                LinkedList ints = new LinkedList();
                ints.add(i);
                location.put(nums[i], ints);
            } else {
                location.get(nums[i]).add(i);
            }
        }
        //查询
        Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = location.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, LinkedList<Integer>> entry = iterator.next();
            Integer integer = entry.getKey();
            LinkedList<Integer> linkedList = entry.getValue();
            Integer find = target - integer;
            if (find == integer && linkedList.size() > 1) {
                return new Integer[]{linkedList.getFirst(), linkedList.getLast()};
            }
            if (find != integer && location.get(find) != null) {
                return new Integer[]{linkedList.getFirst(), location.get(find).getFirst()};
            }
        }
        return new Integer[]{-1, -1};
    }

    //双指针法 ，对有序集合进行
    public static Integer[] integers(Integer[] nums, Integer target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum == target) {
                return new Integer[]{left, right};
            } else {
                right--;
            }
        }
        return new Integer[]{-1, -1};
    }

    //    Map<Integer,Integer> count = new HashMap<>();
    public void add(int number) {

    }

    public void find(int number) {

    }
}
