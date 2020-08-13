package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * 通过次数119,600提交次数213,238
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 15:07
 **/
public class Num38外观数列 {
    /**
     * 递归查询
     *
     * @param n
     * @return
     */

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String beforeOne = countAndSay(n - 1);
        int length = beforeOne.length();
        char now = beforeOne.charAt(0);
        int count = 1;
        int num = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (num < length) {
            char s = beforeOne.charAt(num);
            if (s == now) {
                count++;
            } else {

                stringBuilder.append(count + String.valueOf(now));
                now = s;
                count = 1;
            }
            num++;
        }
        stringBuilder.append(count + String.valueOf(now));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int now = 30;
        String s = new Num38外观数列().countAndSay(now);
        System.out.println(s);
    }
}
