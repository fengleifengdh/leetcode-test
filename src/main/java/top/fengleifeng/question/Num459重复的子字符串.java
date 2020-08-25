package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * 通过次数39,535提交次数77,782
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-24 17:43
 **/
public class Num459重复的子字符串 {
    class Solution {
        //暴力法
        public boolean repeatedSubstringPattern(String s) {
            int length = s.length();
            if (s.length() <= 0) {
                return false;
            }

            for (int i = 1; i <= length / 2; i++) {
                if (length % i == 0) {
                    boolean reslt= true;
                    for (int j = i; j < length; j++) {
                        if (s.charAt(j) != s.charAt(j - i)) {
                            reslt = false;
                            break;
                        }
                    }
                    if(reslt){
                        return true;
                    }
                }
            }
            return false;
        }
        //根据复制查找
        public boolean repeatedSubstringPattern2(String s) {
            return (s + s).indexOf(s, 1) != s.length();
        }


    }
}
