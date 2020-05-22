package top.fengleifeng.总结.滑动窗口;

import top.fengleifeng.util.Constants;

import java.util.*;

/**
 * @program: leetcode-test
 * @description: 给你一个字符串S 和字符串T，请在S中找出 包含T所有字母的字母异位词
 * * 比如"ZBCAQQCABQ" T="ABC"
 * * 输出 [1,6]
 * @author: fengleifeng
 * @create: 2020-05-22 11:37
 **/
public class 找到字符串中的所有字母异位词 {
    public static void main(String[] args) {
        String s = "ZBCAQQCABQ";
        String t = "ABC";
        Integer[] y = find(s, t);
        Constants.printArr(y);
    }

    public static Integer[] find(String s, String t) {
        List<Integer> result = new ArrayList<>();
//        Integer[] result = new Integer[s.length()];
        int left = 0;
        int right = 0;
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), i);
        }
        int match = 0;
        int nowStep = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, right);
            queue.add(c);
            int temp = right;
            right++;
            //判断是第几位
            if (right < t.length()) {
                continue;
            }
            if (match(temp, windows, needs)) {
//                result[nowStep++] = right - needs.size();
                result.add(right - needs.size());
            }
            Character c1 = queue.poll();
            windows.remove(c1);
            left++;
        }
        Integer[] integers = new Integer[result.size()];
        for (int i = 0; i < result.size(); i++) {
            integers[i] = result.get(i);
        }
        return integers;
    }

    private static boolean match(int right, HashMap<Character, Integer> windows, HashMap<Character, Integer> needs) {
        Iterator<Map.Entry<Character, Integer>> iterator = needs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> map = iterator.next();
            Character key = map.getKey();
            Integer value = map.getValue();
            if (windows.containsKey(key)) {
                if ((windows.get(key) + needs.size() - right - 1) == (value)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


}
