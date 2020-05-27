package top.fengleifeng.other.算法;

import java.util.*;

/**
 * @program: leetcode-test
 * @description: 信封有长宽
 * [1,3],[2,4],[2,3],[4,6]
 * <p>
 * 2,4信封可以嵌套1，3
 * 现在有一串数组从这里面选出最长的嵌套信封
 * 上面最长：[1,3]-》[2,4]-》[4,6]
 * @author: fengleifeng
 * @create: 2020-05-27 21:01
 **/
public class 信封嵌套 {
    public static void main(String[] args) {
//        int[] ints = Constants.;
        List<Integer[]> list = new LinkedList<>();
        list.add(new Integer[]{1, 3});
        list.add(new Integer[]{2, 4});
        list.add(new Integer[]{2, 3});
        list.add(new Integer[]{4, 6});
        list.add(new Integer[]{1, 2});
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] == o2[1]) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        list.forEach(one -> System.out.print(one[0] + ":" + one[1] + ","));
//        System.out.println();
        num(list);

    }

    //回溯算法
    public static void num(List<Integer[]> list) {
        container.add(new ArrayList<>());
        Integer[] one = list.get(0);
        List<Integer[]> ooooo = new ArrayList<>();
        ooooo.add(list.get(0));
        choose(ooooo, 1, list);
        System.out.println("");
    }

    static List<List<Integer[]>> container = new ArrayList<>();

    public static void choose(List<Integer[]> list, int n, List<Integer[]> source) {

        int size = source.size();
        for (int i = n; i < size; i++) {
            Integer[] now = source.get(i);
            Integer[] temp = list.get(list.size() - 1);
            if (temp[0] < now[0] && temp[1] < now[1]) {
                int index = list.size();
                list.add(index, now);
                choose(list, n + 1, source);
                if (list.size() > container.get(0).size()) {
                    container.clear();
                    container.add(new ArrayList<>(list));
                } else if (list.size() == container.get(0).size()) {
                    container.add(new ArrayList<>(list));
                }
                list.remove(index);
            }
        }

    }

}
