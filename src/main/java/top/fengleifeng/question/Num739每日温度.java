package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Stack;

/**
 * @program: leetcode-test
 * @description: 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 通过次数95,142提交次数147,858
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 17:47
 **/
public class Num739每日温度 {
    /**
     * 单调栈解法
     */
    public int[] nextGreaterElement(int[] source) {
        int length = source.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.empty() && source[stack.peek()] <= source[i]) {
                stack.pop();
            }
            result[i] = stack.empty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
    /**
     * 暴力解法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
                if (j == length - 1) {
                    result[i] = 0;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new Num739每日温度().dailyTemperatures(T);
        Constants.printArr(ints);

        int[] intss = new Num739每日温度().nextGreaterElement(T);
        Constants.printArr(intss);
    }
}
