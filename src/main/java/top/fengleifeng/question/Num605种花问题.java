package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-03 16:09
 **/
public class Num605种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
//        if (flowerbed.length <= 1) {
//            num = flowerbed[0];
//            return num >= n;
//        }
        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 1) {
//                continue;
//            }
//            if (i == 0) {
//                if (flowerbed[1] == 0) {
//                    num++;
//                }
//            } else if (i == flowerbed.length - 1) {
//                if (flowerbed[i - 1] == 0) {
//                    num++;
//                }
//            } else {
//                if (flowerbed[i + 1] != 1 && flowerbed[i - 1] != 1) {
//                    num++;
//                }
//            }
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                num++;
                flowerbed[i] = 1;
            }
        }
        return num >= n;
    }

    public static void main(String[] args) {
        int[] i = {1};
//        int[] i = {1, 0, 0, 0,0, 1};
        int num = 2;
        boolean result = new Num605种花问题().canPlaceFlowers(i, num);
        System.out.println(result);
    }
}
