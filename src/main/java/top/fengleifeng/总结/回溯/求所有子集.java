package top.fengleifeng.总结.回溯;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-27 14:26
 **/
public class 求所有子集 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        choose(ints, ints.length);

        //
    }


    public static LinkedList<Integer[]> choose(int[] source, int n) {
        LinkedList<Integer[]> linkedList = null;
        if (n == 0) {
            linkedList = new LinkedList<>();
            linkedList.add(new Integer[]{});
            return linkedList;
        }
        linkedList = choose(source, n - 1);
        int now = source[n-1];
        int size = linkedList.size();
        for (int j = 0; j < size; j++) {
            Integer[] arr = linkedList.get(j);
            Integer[] newArr = Arrays.copyOf(arr, arr.length + 1);
            newArr[newArr.length - 1] = now;
            linkedList.add(newArr);
        }
        return linkedList;
    }
}
