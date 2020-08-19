package top.fengleifeng.总结.单调队列;

import top.fengleifeng.util.Constants;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-13 19:51
 **/
public class Solution {

    public int[] maxSlidingWindow(int[] source, int num) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        int[] ints = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (i < num - 1) {
                monotonicQueue.push(source[i]);
                ints[i] = monotonicQueue.max();
            } else {
                monotonicQueue.push(source[i]);
                ints[i] = monotonicQueue.max();
                monotonicQueue.pop(source[i - num + 1]);
            }
        }
        return ints;
    }
    //单调队列

    class MonotonicQueue {
        private Deque<Integer> deque;
        public MonotonicQueue(){
            deque = new LinkedList<>();
        }
        public int max() {
            return deque.getFirst();
        }

        public void push(int n) {
            while (!deque.isEmpty() && deque.getLast() < n) {
                deque.removeLast();
            }
            deque.addLast(n);
        }

        public void pop(int n) {
            while (!deque.isEmpty() && deque.getFirst() == n) {
                deque.removeFirst();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] o = {1, 5, 3, 25, 24, 24, 24, 26, 2, 14, 145};
        int num = 3;
        int[] ints = new Solution().maxSlidingWindow(o, num);
        Constants.printArr(ints);
    }
}
