package top.fengleifeng.总结.蓄水池;

import top.fengleifeng.util.ListNode;

import java.util.Random;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-11 10:21
 **/
public class Solution {
    ListNode root;
    Random random = new Random();

    public Solution(ListNode head) {
        this.root = head;
    }

    /**
     * Returns a random node's value.
     * 算法思路大致如下：
     *
     * 如果接收的数据量小于m，则依次放入蓄水池。
     * 当接收到第i个数据时，i >= m，在[0, i]范围内取以随机数d，若d的落在[0, m-1]范围内，则用接收到的第i个数据替换蓄水池中的第d个数据。
     * 重复步骤2。
     */
    public int getRandom() {
        ListNode head = root;
        //因为返回一个值 所以 蓄水池 容量为1
        //蓄水池的水 就是 链表中的每个值.
        int[] res = {-1};
        int count = 0; //水的数量
        boolean isFull = false; //蓄水池是否已满
        while (head != null) {
            count++;  //数量加1;
            if (!isFull) {
                res[0] = head.val;
                isFull = true; //将蓄水池 灌满  设置isFull为true;
            } else {
                //蓄水池代码的模板，直接套用。
                int i = random.nextInt(count);//[0,count)
                if (i < 1) {
                    res[0] = head.val;
                }
            }
            head = head.next;

        }
        return res[0];
    }

    public static void main(String[] args) {

    }
}
