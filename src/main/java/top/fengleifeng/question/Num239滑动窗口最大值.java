package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-09-03 17:09
 **/
public class Num239滑动窗口最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            Deque<Integer> deque = new LinkedList<>();
            int length = nums.length;
            int[] result = new int[length - k + 1];
            //添加初始数据
            for (int i = 0; i < k - 1; i++) {
                dataClear(deque, nums[i], k, null);
            }
            //进行数据遍历
            for (int i = k - 1; i < nums.length; i++) {
                int one = nums[i];
                int removeIndex = i - k;
                Integer removeData = null;
                if (removeIndex >= 0) {
                    removeData = nums[i - k];
                }
                //进行比较
                dataClear(deque, one, k, removeData);
                result[i - k + 1] = deque.getFirst();
            }
            return result;
        }

        public void dataClear(Deque<Integer> deque, int data, int k, Integer removeData) {
//            int size = deque.size();
            if (null != removeData) {
                if (deque.size() > 0) {
                    if (deque.getFirst() == removeData.intValue()) {
                        deque.removeFirst();
                    }
                }
            }
            if (deque.size() > 0) {
                Integer temp = deque.getLast();
                while (deque.size() > 0) {
                    if (data > temp) {
                        deque.removeLast();
                        if (deque.size() > 0) {
                            temp = deque.getLast();
                        }
                    } else {
                        if (deque.size() >= k) {
                            deque.removeFirst();
                        }
                        deque.addLast(data);
                        break;
                    }
                }
                if (deque.size() <= 0) {
                    deque.addLast(data);
                }

            } else {
                deque.addLast(data);
            }
        }
    }

    public static void main(String[] args) {
//        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
//        int[] ints = {1, -1};
//        int k = 1;
//        int[] ints1 = new Num239滑动窗口最大值().new Solution().maxSlidingWindow(ints, k);
//        Constants.printArr(ints1);
    }
}
