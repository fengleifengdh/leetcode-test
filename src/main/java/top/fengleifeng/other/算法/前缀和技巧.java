package top.fengleifeng.other.算法;

import top.fengleifeng.util.Constants;

import java.util.HashMap;

/**
 * @program: leetcode-test
 * @description: 原数组 a[i]
 * 对于经常需要求和的数组为了优化
 * 开辟已个新数组存储 b[i+1]
 * b[i+1] = a的前i个数的和
 * b[0]=0;
 * @author: fengleifeng
 * @create: 2020-05-27 17:02
 **/
public class 前缀和技巧 {
    /**
     * 给一个数组
     * 算出一共有几个和为 k 的子数 组。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = Constants.IntNotSortOne;
        Constants.printArr(ints);
        int k = 11;
        int num = find(ints, k);
        System.out.println(num);
    }

    public static int find(int[] ints, int k) {
        int result = 0;
        //用来存储可能出现的值
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum_i = 0;int sum_j = 0;
        for (int i = 0; i < ints.length; i++) {
            sum_i = sum_i + ints[i];
            sum_j = sum_i - k;
            if (hashMap.containsKey(sum_j)) {
                result = result + hashMap.get(sum_j);
            }
            hashMap.put(sum_i, hashMap.getOrDefault(sum_i, 0) + 1);
        }

        return result;
    }

    public static int find2(int[] ints, int k) {
        int result = 0;

        int[] sum = new int[ints.length + 1];
        sum[0] = 0;
        for (int i = 0; i < ints.length; i++) {
            sum[i + 1] = sum[i] + ints[i];
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                if(sum[i]-sum[j] == k){
                    result++;
                }
            }
        }

        return result;
    }
}
