package top.fengleifeng.question;

import top.fengleifeng.util.Constants;
import top.fengleifeng.util.ListNode;

/**
 * @program: leetcode-test
 * @description: 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-01 19:43
 **/
public class Num234回文链表 {
    /**
     * 思路：
     * 快慢指针找中点
     * 翻转前连半段
     * 从中点判断是否相等
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head, fast = head;
            ListNode pre = head, prepre = null;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                pre.next = prepre;
                prepre = pre;
            }
            if (fast != null) {
                slow = slow.next;
            }
            while (pre != null && slow != null) {
                if (pre.val != slow.val) {
                    return false;
                }
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
