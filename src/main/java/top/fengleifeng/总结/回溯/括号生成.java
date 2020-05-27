package top.fengleifeng.总结.回溯;

import top.fengleifeng.util.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 输入数字n, 生成n个（）括号，并且合法
 * @author: fengleifeng
 * @create: 2020-05-27 16:29
 **/
public class 括号生成 {
    public static void main(String[] args) {
        String s = "123";
        choose(3);
    }

    static List<String> list = new LinkedList<>();

    public static void choose(int n) {
        int max = n << 1;
        recall("", 0, max, n, n);

        list.forEach(one-> System.out.println(one+","));
    }

    public static void recall(String now, int n, int max, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(now);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (1 == i) {
                if (left > 0) {
                    String temp = now;
                    temp = temp + "(";
                    if (!vaild(temp)) {
                        continue;
                    }
                    now = temp;
                    recall(now, n, max, left - 1, right);
                    now = now.substring(0,now.length()-1);
                }
            } else {
                if (right > 0) {
                    String temp = now;
                    temp = temp + ")";
                    if (!vaild(temp)) {
                        continue;
                    }
                    now = temp;
                    recall(now, n, max, left, right-1);
                    now = now.substring(0,now.length()-1);

                }
            }
        }
    }

    private static boolean vaild(String temp) {
        char[] chars = temp.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left < right) {
                return false;
            }
        }

        return true;
    }
}
