package top.fengleifeng.总结.单调栈;

import top.fengleifeng.util.Constants;

import java.util.Stack;

/**
 * @program: leetcode-test
 * @description: 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 * 这道题的暴力解法很好想到，就是对每个元素后面都进行扫描，找到第一个更大的元素就行了。但是暴力解法的时间复杂度是 O(n^2)。
 * @author: fengleifeng
 * @create: 2020-08-13 18:51
 **/

/**
 * vector<int> nextGreaterElement(vector<int>& nums) {
 * vector<int> ans(nums.size()); // 存放答案的数组
 * stack<int> s;
 * for (int i = nums.size() - 1; i >= 0; i--) { // 倒着往栈里放
 * while (!s.empty() && s.top() <= nums[i]) { // 判定个子高矮
 * s.pop(); // 矮个起开，反正也被挡着了。。。
 * }
 * ans[i] = s.empty() ? -1 : s.top(); // 这个元素身后的第一个高个
 * s.push(nums[i]); // 进队，接受之后的身高判定吧！
 * }
 * return ans;
 * }
 */
public class Soluation {
    /**
     * 不是循环数据
     *
     * @param source
     * @return
     */
    public int[] nextGreaterElement(int[] source) {
        int length = source.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= source[i]) {
                stack.pop();
            }
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.push(source[i]);
        }
        return result;
    }

    /**
     * 循环数据
     *
     * @param source
     */
    public int[] nextGreaterElement2(int[] source) {
        int length = source.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= source[i % length]) {
                stack.pop();
            }
            result[i % length] = stack.empty() ? -1 : stack.peek();
            stack.push(source[i % length]);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {2, 1, 2, 4, 3};
        int[] ints1 = new Soluation().nextGreaterElement(ints);
        Constants.printArr(ints1);
        int[] ints12 = new Soluation().nextGreaterElement2(ints);
        Constants.printArr(ints12);
    }
}
