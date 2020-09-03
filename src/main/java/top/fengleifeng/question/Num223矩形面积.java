package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-02 20:19
 **/
public class Num223矩形面积 {

    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int height = 0;
            int weight = 0;
            //获取weight;
            if (E > C || G < A) {
                weight =  0;
            }else {
                weight = getint(A, C, E, G);
            }
            //获取height;
            if (B > H || F > D) {
                height =  0;
            }else{
                height = getint(B, D, F, H);
            }
            //return
            int sizeMul = height * weight;

            int oneSize = (C - A) * (D - B);
            int twoSize = (G - E) * (H - F);
            return oneSize + twoSize -sizeMul;
        }

        public int getint(int x1, int x2, int y1, int y2) {
            int one = 0;
            int two = 0;
            if (x1 >= y1) {
                one = x1;
                if (x2 >= y2) {
                    two = y2;
                } else {
                    two = x2;
                }
            } else {
                one = y1;
                if (x2 >= y2) {
                    two = y2;
                } else {
                    two = x2;
                }
            }
            return two - one;
        }
    }

    public static void main(String[] args) {

//        int A = -2, B = -2, C = 2, D = 2, E = 3, F = 3, G = 4, H = 4;
        int A = -5, B = -5, C = -4, D = 0, E = -3, F = -3, G = 3, H = 3;

        int i = new Num223矩形面积().new Solution().computeArea(A, B, C, D, E, F, G, H);
        System.out.println(i);
    }
}
