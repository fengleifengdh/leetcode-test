package top.fengleifeng.总结.bfsAndDfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-21 19:27
 **/
public class 转动锁需要 {

    public static void main(String[] args) {
        String[] de = {"0101"};
        System.out.println(BFS(de, "0120"));
    }

    public static int BFS(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();//防重复
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                String cur = q.poll();
                //是否到终点
                if (cur.equals(target)) {
                    return step;
                }
                //是否到终点
                if (deads.contains(cur)) {
                    continue;
                }
                //
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static int TwoBFS(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        Queue<String> q1 = new LinkedList();
        Queue<String> q2 = new LinkedList();

        Set<String> visited = new HashSet();//防重复
        int step = 0;
        q1.offer("0000");
        q2.offer(target);
//        visited.add("0000");
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Queue<String> temp = new LinkedList();
            for (int i = 0; i < q1.size(); i++) {
                String cur = q1.poll();
                //是否到终点
                if (cur.equals(target)) {
                    return step;
                }
                //是否到终点
                if (deads.contains(cur)) {
                    continue;
                }
                //
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q1.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q1.offer(down);
                        visited.add(down);
                    }
                }


            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }


    public static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    public static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
