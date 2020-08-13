package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.Arrays;

/**
 * @program: leetcode-test
 * @description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 14:51
 **/
public class Num66加一 {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int k = 1;//进位数
        int num = length - 1;
        while (k > 0) {
            if (num < 0) {
                //位数不够的情况
                int[] newDigits = new int[length + 1];
                newDigits[0] = k;
                for (int i = 1; i < length + 1; i++) {
                    newDigits[i] = digits[i - 1];
                }
                digits = newDigits;
                k = 0;
            } else {
                int sum = digits[num] + k;
                if (sum >= 10) {
                    k = sum / 10;
                    digits[num] = sum % 10;
                    num--;
                }else{
                    k = 0;
                    digits[num] = sum;
                }
            }
        }

        return digits;
    }

    public static void main(String[] args) {
//        int[] o = {1,2,3};
        int[] o = {9};
        int[] ints = new Num66加一().plusOne(o);
        Constants.printArr(ints);
    }
}
