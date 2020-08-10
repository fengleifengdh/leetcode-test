package top.fengleifeng.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * 通过次数27,902提交次数45,909
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-10 16:53
 **/
public class Num696计数二进制子串 {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

    public int countBinarySubstrings1(String s) {
        System.out.println(s);
        int length = s.length();
        int result = 0;

        int start = 0;
        char startChar;
        while (start < length) {
            startChar = s.charAt(start);

            int startnum = 1;
            int endnum = 0;
            for (int i = start + 1; i < length + 1; i++) {
                char now;
                if (i == length) {
                    now = 'a';
//                    endnum++;
                    if (startnum == endnum) {
                        System.out.println(s.substring(start, i));
                        result++;
                        break;
                    }
                } else {
                    now = s.charAt(i);
                    if (now == startChar && endnum == 0) {
                        startnum++;
                    } else if (now == startChar && endnum != 0) {
                        if (startnum == endnum) {
                            System.out.println(s.substring(start, i));
                            result++;
                            break;
                        } else {
                            break;
                        }
                    } else if (now != startChar) {
                        endnum++;
                        if (endnum == startnum) {
                            System.out.println(s.substring(start, i + 1));
                            result++;
                            break;
                        } else if (endnum > startnum) {
                            break;
                        }
//                    } else if (now != startChar && endnum != 0) {
//                        endnum++;
                    }
                }
            }
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
//        String s = "000111000";
        String s = "00110";
        int i = new Num696计数二进制子串().countBinarySubstrings(s);
        System.out.println(i);
    }
}
