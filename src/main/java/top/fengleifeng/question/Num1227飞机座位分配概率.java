package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
 * <p>
 * 剩下的乘客将会：
 * <p>
 * 如果他们自己的座位还空着，就坐到自己的座位上，
 * <p>
 * 当他们自己的座位被占用时，随机选择其他座位
 * 第 n 位乘客坐在自己的座位上的概率是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1.00000
 * 解释：第一个人只会坐在自己的位置上。
 * 示例 2：
 * <p>
 * 输入: n = 2
 * 输出: 0.50000
 * 解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/airplane-seat-assignment-probability
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-10 19:07
 *
 * TODO
 **/
public class Num1227飞机座位分配概率 {
    public double nthPersonGetsNthSeat(int n) {
        int[] k = new int[n];

        check(n, k);
        return 0;
    }

    void check(int personNum, int[] weizhi) {
//        int[] k = new int[personNum];
        for (int i = 0; i < personNum; i++) {

        }
    }

    public static void main(String[] args) {


    }
}
