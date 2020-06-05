package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description: 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 思路：
 * 总体就是循环对数据位置找到规律进行数据的交换
 * [0,0]->[0-2]
 * [0,1]->[1-2]
 * [0,2]->[2-2]
 * [1,0]->[0-1]
 * [1,1]->[1-1]
 * [1,2]->[2-2]
 * [2,0]->[0-0]
 * [2,1]->[1-0]
 * [2,2]->[2-0]
 * @author: fengleifeng
 * @create: 2020-06-05 15:09
 **/
public class Num48 {
    public static void main(String[] args) {
        int[][] ints = Constants.IntSortThree;
        Constants.printArrs(ints);
        new Num48().rotate(ints);
        Constants.printArrs(ints);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //第一个for代表需要循环的层数
        for (int i = 0; i < n / 2; ++i) {
            //这一层需要交换数据几次
            for (int j = i; j < n - 1 - i; ++j) {
                /* 因为顺时针旋转，所以该值时要逆时针改 */
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
                Constants.printArrs(matrix);
            }
        }

    }

    public void swap(int[][] matrix, int oneX, int oneY, int twoX, int twoY) {
        int temp = matrix[oneX][oneY];
        matrix[oneX][oneY] = matrix[twoX][twoY];
        matrix[twoX][twoY] = temp;
    }
}
