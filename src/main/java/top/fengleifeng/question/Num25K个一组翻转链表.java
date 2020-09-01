package top.fengleifeng.question;

import top.fengleifeng.util.Constants;
import top.fengleifeng.util.ListNode;

/**
 * @program: leetcode-test
 * @description: 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 通过次数96,096提交次数153,212
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-26 11:57
 **/
public class Num25K个一组翻转链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode result = null;
            ListNode listNode = head;
            int count = 1;
            ListNode qianlistNode = null;
            ListNode listNodeFirst = null;
            ListNode listNodeEnd = null;
            boolean flag = false;
            while (listNode != null) {
                ListNode tempNext = listNode.next;
                if (count == 1) {
                    listNodeFirst = listNode;
                }
                if (count == k) {
                    //进行反转
                    listNodeEnd = listNode;
                    change(listNodeFirst, listNodeEnd, qianlistNode);
                    qianlistNode = listNodeFirst;
                    if (!flag) {
                        flag = true;
                        result = listNodeEnd;
                    }
                    count = 0;
                }
                count++;
                listNode = tempNext;
            }
            if(count!=1 && flag){
                qianlistNode .next = listNodeFirst;
            }
            if (!flag) {
                flag = true;
                result = head;
            }
            return result;
        }

        void change(ListNode start, ListNode end, ListNode qian) {
            if (null != qian) {
                qian.next = end;
            }
            boolean flag = false;
            ListNode temp = start;
            ListNode next = null;
            while (temp != null ) {
                ListNode now = temp;
                ListNode nowNext = temp.next;
                now.next = next;
                next = now;
                if(temp==end){
                    break;
                }
                temp = nowNext;

            }
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
        ListNode listNode = new Num25K个一组翻转链表().new Solution().reverseKGroup(one, 6);
        Constants.printListNode(listNode);
    }
}
