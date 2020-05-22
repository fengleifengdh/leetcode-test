package top.fengleifeng.总结.滑动窗口;

import java.util.HashMap;

/**
 * @program: leetcode-test
 * @description: 给你一个字符串S 和字符串T，请在S中找出 包含T所有字母的最小子串
 * 比如"ADOQWEVNZBCQAQ" T="ABC"
 * 输出 BCQA
 * @author: fengleifeng
 * @create: 2020-05-22 10:09
 **/
public class 最小覆盖子串 {
    public static void main(String[] args) {
//        String s = "1";
//        String window = s.substring(0, 1);
        System.out.println(find("ADOQWEVNZBCQAQ", "ABC"));
    }

    public static String find(String s, String t) {
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String res = s;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (null == needs.get(t.charAt(i))) {
                needs.put(t.charAt(i), 1);
            } else {
                needs.put(t.charAt(i), needs.get(t.charAt(i)) + 1);
            }
        }
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (null == windows.get(c1)) {
                windows.put(c1, 1);
            } else {
                windows.put(c1, windows.get(c1) + 1);
            }
            if (needs.containsKey(c1)) {// 判断是否存在
                if (windows.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                String k = s.substring(left, right);
                res = res.length() < windows.size() ? res : k;
                if (right - left < minLen) {
                    // 更新最小子串的位置和⻓度 start = left;
                    minLen = right - left ;
                }
                char c2 = s.charAt(left);
                windows.put(c2, windows.get(c2) - 1);
                if (windows.get(c2) <= 0) {
                    windows.remove(c2);
                }
                if (needs.containsKey(c2)) {
                    if (null == windows.get(c2) || windows.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : res;
    }

    public static boolean windowMatch(String s, int left, int right) {

        return false;
    }
}
