package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-01 20:22
 **/
public class Num241为运算表达式设计优先级 {

    class Solution {
        private List<Integer> numList;
        private List<Character> operatorList;
        private List<Integer>[][] memo;

        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> result = new LinkedList<>();
            setData(input);
            int len = numList.size();
            memo = new ArrayList[len][len];
            return rec(0, len - 1);
        }

        private List<Integer> rec(int start, int end) {
            if (memo[start][end] != null) {
                return memo[start][end];
            }

            if (start == end) {
                memo[start][end] = new ArrayList<>(Collections.singleton(numList.get(start)));
                return memo[start][end];
            }
            List<Integer> ansList = new ArrayList<>();
            for (int i = start; i < end; i++) {
                List<Integer> leftList = rec(start, i);
                List<Integer> rightList = rec(i + 1, end);
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        ansList.add(cal(operatorList.get(i), left, right));
                    }
                }
            }
            memo[start][end] = ansList;
            return ansList;
        }

//        private List<Integer> rec(int start, int end) {
//            if (memo[start][end] != null) {
//                return memo[start][end];
//            }
//
//            if (start == end) {
//                memo[start][end] = new ArrayList<>(Collections.singleton(numList.get(start)));
//                return memo[start][end];
//            }
//
//            List<Integer> ansList = new ArrayList<>();
//            for (int i = start; i < end; i++) {
//                List<Integer> leftList = rec(start, i);
//                List<Integer> rightList = rec(i + 1, end);
//                for (Integer leftNum : leftList) {
//                    for (Integer rightNum : rightList) {
//                        ansList.add(cal(operatorList.get(i), leftNum, rightNum));
//                    }
//                }
//            }
//
//            memo[start][end] = ansList;
//            return ansList;
//        }

        private void setData(String input) {
            numList = new ArrayList<>();
            operatorList = new ArrayList<>();
            char[] c = input.toCharArray();
            int num = 0;
            for (char one : c) {
                if (!Character.isDigit(one)) {
                    operatorList.add(new Character(one));
                    numList.add(num);
                    num = 0;
                } else {
                    num = num * 10;
                    num = num + one - '0';
                }
            }
            numList.add(num);
        }

        private Integer cal(char c, int one, int two) {
            switch (c) {
                case '+':
                    return one + two;
                case '-':
                    return one - two;
                case '*':
                    return one * two;
                default:
                    return one + two;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Num241为运算表达式设计优先级().new Solution().diffWaysToCompute("2*3-4*5");

        Constants.pringLinkedList(list);
    }
}
