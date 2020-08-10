package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启, 关闭].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭, 关闭].
 * 第四轮后, 灯泡状态 [开启, 关闭, 关闭, 开启].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-10 18:45
 **/
public class Num319灯泡开关 {
    /**
     * 思路：
     * 主要是看会被操作几次，操作基数次就会 开启
     * 1个灯泡会操作1次
     * 2个灯泡 第二个操作2次
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
//double d = Double.parseDouble(n+"");
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(new Num319灯泡开关().bulbSwitch(10));
    }
}
