package top.fengleifeng.other.动态规划;

//

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] k = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(k));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int min = Math.min(height[i], height[j]);
                int tiji = min * (j - i);
                max = Math.max(max, tiji);

            }
        }
        return max;
    }
}
