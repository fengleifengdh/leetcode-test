package top.fengleifeng.other.算法;

import java.util.Stack;

/**
 * @program: leetcode-test
 * @description: 包含加减和数字
 * 求最后数字
 * 2+3-1
 * 思路:
 * +2 和+3 和-1
 * 将所有数据都进行
 * @author: fengleifeng
 * @create: 2020-05-26 20:07
 **/
public class 加减求和 {
    public static void main(String[] args) {
        String str = "2*3-1";
        System.out.println(getInt(str));
    }

    public static Integer getInt(String string) {
        char[] chars = string.toCharArray();
        Stack<Integer> stack = new Stack<>();//利用栈来实现

        //判断第一个字符是不是+或者-号
        //
        char first = chars[0];
        char flag = '+';
        int i = 0;
        if (first == '-') {
            flag = '-';
            i = i + 1;
        }
        Integer integer = 0;
        for (; i < chars.length; i++) {
            char now = chars[i];
            if (now >= '0' && now <= '9') {
                integer = integer * 10 + (now - '0');
            }
            if (i == chars.length - 1 || now == '+' || now == '-'|| now == '*'|| now == '/') {
                if (flag == '-') {
                    stack.push(-integer);
                } else if (flag == '*'){
                    Integer temp = stack.pop();
                    temp = temp*now;
                    stack.push(temp);
                } else if (flag == '/'){
                    Integer temp = stack.pop();
                    temp = temp/now;
                    stack.push(temp);
                } else if (flag == '+'){
                    stack.push(integer);
                }
                flag = now;
                integer = 0;
            }
        }
        Integer result = 0;
        while (!stack.isEmpty()) {
            int now = stack.pop();
            result += now;
        }
        return result;
    }
}
