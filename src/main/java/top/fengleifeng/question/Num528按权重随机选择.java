package top.fengleifeng.question;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-11 16:34
 **/
public class Num528按权重随机选择 {

    class Solution {
        int[] data;
        int sum;
        Random random = new Random();
        public Solution(int[] w) {
            //对数据进行处理
            data = new int[w.length];
            data[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                data[i] = data[i - 1] + w[i];
            }
            sum = data[w.length - 1];
        }
        public int pickIndex() {
            int s = random.nextInt(sum );//[0,sum]
            int index = Arrays.binarySearch(data, s+1 );
            if (index < 0) {
                return -index - 1;
            }
            return index;
        }
    }

}
