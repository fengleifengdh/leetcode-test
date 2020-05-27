package top.fengleifeng.other.算法;

import top.fengleifeng.util.Constants;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-27 10:37
 **/
public class 烧饼排序 {
    public static void main(String[] args) {
        int[] cake = Constants.IntNotSortOne;
        Constants.printArr(cake);
        System.out.println();
        sort(cake, cake.length);
        Constants.printArr(cake);
        System.out.println();
        list.forEach(one -> System.out.print(one+","));
    }

    public static List<Integer> list = new LinkedList<>();

    //将数组前n个排序
    public static void sort(int[] source, int n) {
        if (n == 1) {
            return;
        }
        //找到最大的饼 默认第一个最大
        int cake = source[0];
        int cakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (source[i] > cake) {
                cake = source[i];
                cakeIndex = i;
            }
        }
        //进行翻转
        reverse(source,cakeIndex,n);
        list.add(cake);
        //进行下一次翻转
        sort(source, n - 1);
    }
    public static void reverse(int[] source,int index,int n){
        Stack<Integer> stack =new Stack<>();
        for (int i = index; i < n; i++) {
            stack.push(source[i]);
        }
        while (!stack.isEmpty()){
            source[index++] = stack.pop();
        }
    }
}
