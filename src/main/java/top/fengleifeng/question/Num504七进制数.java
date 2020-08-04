package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * <p>

    10转各进制
 * @author: fengleifeng
 * @create: 2020-08-03 20:29
 **/
public class Num504七进制数 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int flag = num >= 0 ? 1 : -1;
        num = Math.abs(num);

        if (num == 0) {
            sb.append(0);
        }
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (flag < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        int num = 101;
        String result = new Num504七进制数().convertToBase7(num);
        System.out.println(result);
    }
}
