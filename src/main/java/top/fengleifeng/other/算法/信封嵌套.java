package top.fengleifeng.other.算法;

import top.fengleifeng.util.Constants;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: leetcode-test
 * @description:
 * 信封有长宽
 * [1,3],[2,4],[2,3],[4,6]
 *
 * 2,4信封可以嵌套1，3
 * 现在有一串数组从这里面选出最长的嵌套信封
 * 上面最长：[1,3]-》[2,4]-》[4,6]
 * @author: fengleifeng
 * @create: 2020-05-27 21:01
 **/
public class 信封嵌套 {
    public static void main(String[] args) {
        int[][] ints = Constants.IntTwoArrSortOne;
        Constants.printArrs(ints);
        System.out.println();
    }

    public void num(int[][] ints)  {
//        Arrays.sort();
    }

}
