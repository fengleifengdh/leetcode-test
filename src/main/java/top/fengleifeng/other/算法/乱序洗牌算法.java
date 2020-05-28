package top.fengleifeng.other.算法;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description:
 * 给定一个数组，打乱其中排序
 * a[n]   总共有 n！ 中排列方式 全排列
 * @author: fengleifeng
 * @create: 2020-05-28 10:23
 **/
public class 乱序洗牌算法 {

    public static void main(String[] args) {
        int[] sort = Constants.IntSortOne;
        Constants.printArr(sort);
        disorganize(sort);
        Constants.printArr(sort);
    }
    public static void disorganize(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            int rand = (int) (Math.random()*(i+1));//[0-i]的随机数       [m-n]  m+1-i
            int temp = ints[i];
            ints[i] = ints[rand];
            ints[rand] = temp;
        }
    }

}
