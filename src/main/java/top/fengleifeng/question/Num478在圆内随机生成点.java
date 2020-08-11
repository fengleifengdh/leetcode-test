package top.fengleifeng.question;

import java.util.Random;

/**
 * @program: leetcode-test
 * @description: 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 * <p>
 * 说明:
 * <p>
 * 输入值和输出值都将是浮点数。
 * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 * 圆周上的点也认为是在圆中。
 * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * 输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * 示例 2：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * 输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * 输入语法说明：
 * <p>
 * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。randPoint 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 * <p>
 * 通过次数3,116提交次数7,425
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-random-point-in-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-11 16:55
 **/
public class Num478在圆内随机生成点 {
    public static void main(String[] args) {
        double d = 1;


        Solution solution = new Num478在圆内随机生成点().new Solution(1.0,0,0);
        double[] doubles = solution.randPoint();
        System.out.println(doubles[0]);
        System.out.println(doubles[1]);
    }
    class Solution {
        double radius;
        double x_center;
        double y_center;
        Random random = new Random();

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            /**
             * x^2+y^2 =
             */
            double l = this.radius * Math.sqrt(random.nextDouble());
            double deg = random.nextDouble() * Math.PI * 2;
            double x = l * Math.cos(deg) + x_center;
            double y = l * Math.sin(deg) + y_center;
            return new double[]{x, y};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
