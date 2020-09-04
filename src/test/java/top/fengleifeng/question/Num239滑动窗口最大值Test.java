package top.fengleifeng.question;

import org.junit.Test;
import top.fengleifeng.util.Constants;

import static org.junit.Assert.*;

public class Num239滑动窗口最大值Test {


    @Test
    public void tes() {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ints1 = new Num239滑动窗口最大值().new Solution().maxSlidingWindow(ints, k);
        Constants.printArr(ints1);
    }

    @Test
    public void tes2() {
        int[] ints = {1, -1};
        int k = 1;

        int[] ints1 = new Num239滑动窗口最大值().new Solution().maxSlidingWindow(ints, k);
        Constants.printArr(ints1);
    }
    @Test
    public void tes3() {
        int[] ints = {7,2,4};
        int k = 2;
        int[] ints1 = new Num239滑动窗口最大值().new Solution().maxSlidingWindow(ints, k);
        Constants.printArr(ints1);
    }
}