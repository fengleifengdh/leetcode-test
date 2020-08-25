package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-24 14:31
 **/
public class Num14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length <= 0) {
            return "";
        }
        String result = "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char one = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].length() <= i || one != strs[j].charAt(i)) {
                    return result;
                }
            }
            result = result + one;
        }
        return result;
    }


    public static void main(String[] args) {
        String[] strs = {"aa", "a",};
        String s = new Num14最长公共前缀().longestCommonPrefix(strs);
        System.out.println(s);
    }


//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int length = strs[0].length();
//        int count = strs.length;
//        for (int i = 0; i < length; i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < count; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }

}
