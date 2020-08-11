package top.fengleifeng.question;

import top.fengleifeng.util.ListNode;

import java.util.Random;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-11 10:38
 **/
public class Num382链表随机节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Solution solution = new Solution(listNode);

        for (int i = 0; i < 100; i++) {
            int random = solution.getRandom();

            System.out.println(random);
        }
    }
}
class Solution {
    /**
     * Returns a random node's value.
     * 算法思路大致如下：
     *
     * 如果接收的数据量小于m，则依次放入蓄水池。
     * 当接收到第i个数据时，i >= m，在[0, i]范围内取以随机数d，若d的落在[0, m-1]范围内，则用接收到的第i个数据替换蓄水池中的第d个数据。
     * 重复步骤2。
     */
    ListNode listNode ;
    Random random = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.listNode = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = listNode.val;
        ListNode temp = listNode;
        int count = 1;
        while (temp.next!=null ){
            temp = temp.next;
            int randomTemp = random.nextInt(count+1);
            if(randomTemp<1){
                res = temp.val;
            }
            count++;
        }
        return res;
    }
}