package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 通过次数133,596提交次数256,106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 15:52
 **/
public class Num42接雨水 {
    /**
     * 思路：
     * 每一个格子可以接的水都是左边最高和右边最高的最低值和自己比较如果高的话就有值，如果低就没值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        if(length<=1){
            return 0;
        }
        int[] leftHight = new int[length];
        int[] rightHight = new int[length];


        //初始化左右最高值
        leftHight[0] = 0;
        for (int i = 1; i < length; i++) {
            leftHight[i] = Math.max(leftHight[i - 1], height[i - 1]);
        }
        leftHight[length - 1] = 0;
        for (int i = length - 2; i > 0; i--) {
            rightHight[i] = Math.max(rightHight[i + 1], height[i+1]);
        }
        int reuslt = 0;
        for (int i = 0; i < length; i++) {
            int min = Math.min(leftHight[i],rightHight[i]);
            if(min>height[i]){
                reuslt += min-height[i];
            }
        }
        return reuslt;
    }

    public static void main(String[] args) {
        int[] ints = {};
//        int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
        Constants.printArr(ints);
        int trap = new Num42接雨水().trap(ints);
        System.out.println(trap);
    }
}
