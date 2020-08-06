package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description: 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 * <p>
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 * [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-06 16:32
 **/
public class Num566重塑矩阵 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = null;
        //校验
        int numsYlength = nums.length;
        int numsXlength = 0;
        if (numsYlength > 0) {
            numsXlength = nums[0].length;
        }
        int maxNum = numsXlength * numsYlength;
        int needNum = r * c;
        if (maxNum != needNum) {
            return nums;
        }
        result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int num = i * nums[i].length + j;
                int Y = num / c;//第几行
                int x = num % c;//第几个
                result[Y][x] = nums[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] int1 = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
//        int[][] int1 = {{1, 2}, {3, 4}};
//        int r = 2;
//        int c = 4;
        int[][] ints = new Num566重塑矩阵().matrixReshape(int1, r, c);
        Constants.printArrs(ints);
    }
}
