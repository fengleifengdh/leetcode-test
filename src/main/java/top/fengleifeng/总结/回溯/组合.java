package top.fengleifeng.总结.回溯;

import java.util.LinkedList;

/**
 * @program: leetcode-test
 * @description: 输入n 和k 计算【1-n]中 k个数的组合
 * @author: fengleifeng
 * @create: 2020-05-27 15:20
 **/
public class 组合 {

    public static void main(String[] args) {
        choose(4, 2);
        System.out.println();
    }

    static LinkedList<LinkedList<Integer>> container = new LinkedList<>();

    public static void choose(int n, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        bbb(new LinkedList<Integer>(), linkedList, k, 0);
    }

    public static void bbb(LinkedList<Integer> road, LinkedList<Integer> linkedList, int k, int now) {
        if (road.size() == k) {
            container.add(new LinkedList<>(road));
            return;
        }
        int siez = linkedList.size();
        for (int i = now; i < siez; i++) {
            Integer one = linkedList.get(i);
            road.add(one);
            linkedList.remove(one);
            bbb(road, linkedList, k, i);
            road.remove(one);
            linkedList.add(i, one);
        }
    }
}
