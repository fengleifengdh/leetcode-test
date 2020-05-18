package top.fengleifeng.question;

import java.util.HashMap;
import java.util.Map;

public class Num3 {

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(new Num3().lengthOfLongestSubstring(str));
        System.out.println(new Num3().lengthOfLongestSubstring2(str));
    }

    //滑动窗口解法
    public int lengthOfLongestSubstring2(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);//有可能找到超过滑动窗口的字符串的位置，所以要和原来的比较
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - left + 1, max);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        int result = 1;
        int tempResult = result;
        String stemp = null;
        char[] arr = s.toCharArray();
        for (int k = 0; k < arr.length - 1; k++) {
            stemp = String.valueOf(s.charAt(k));
            for (int i = k + 1; i < arr.length; i++) {
                if (stemp.contains(String.valueOf(arr[i]))) {
                    if (tempResult > result) {
                        result = tempResult;
                    }
                    tempResult = 1;
                    break;
                } else {
                    stemp = stemp + String.valueOf(arr[i]);
                    tempResult++;
                }
            }
            if (tempResult > result) {
                result = tempResult;
            }
            tempResult = 1;
        }

        if (tempResult > result) {
            result = tempResult;
        }
        return result;
    }
}
