package top.fengleifeng.总结.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-22 14:02
 **/
public class 无重复字符最长子串 {
    public static void main(String[] args) {
        String s = "abcazke";
//        System.out.println(find(s));
        System.out.println(find2(s));
    }

    public static String find2(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        String res = "";
        int count = 0;
        int left = 0, right = 0;
        while (right != s.length()) {
            char c = s.charAt(right);
            int temp = right;
            right++;
            if(windows.containsKey(c)){
                windows.put(c,windows.get(c)+1);
            }else{
                windows.put(c,1);
            }
            while (windows.get(c)>1){
                char c2=s.charAt(left);
                windows.put(c2,windows.get(c2)-1);
                left++;
            }
            int length = right - left;
            if (count < length) {
                res = s.substring(left, right);
            }
        }
        return res;
    }

    /**
     * 答案对的，但是感觉思路有问题
     *
     * @param s
     * @return
     */
    public static String find(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        String res = "";
        int count = 0;
        int left = 0, right = 0;
        while (right != s.length()) {
            char c = s.charAt(right);
            int temp = right;
            right++;
            //判断是否已经有了
            if (windows.containsKey(c)) {
                left = windows.get(c) + 1;
                continue;
            }
            windows.put(c, temp);
            //判断长度
            int length = right - left;
            if (count < length) {
                res = s.substring(left, right);
            }

        }
        return res;
    }


}
