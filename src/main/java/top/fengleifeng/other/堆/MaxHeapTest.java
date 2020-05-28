package top.fengleifeng.other.堆;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-28 16:15
 **/
public class MaxHeapTest {
    public static void main(String[] args) {
        int[] ints = Constants.IntNotSortOne;
        MaxHeap maxHeap = new MaxHeap(ints.length);
        Constants.printArr(ints);
        for(int i = 0; i < ints.length; i++){
            maxHeap.insert(ints[i]);
        }
        for(int i = ints.length-1; i >=0 ; i--){
            ints[i] = maxHeap.deleteMax();
        }
        Constants.printArr(ints);
    }
}
