package top.fengleifeng.question;

import top.fengleifeng.util.Constants;
import top.fengleifeng.util.ListNode;

import java.util.List;

/**
 * @program: leetcode-test
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-03 19:06
 **/
public class Num21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return check(l1.val > l2.val ? l2 : l1, l1.val < l2.val ? l2 : l1);
    }

    private ListNode check(ListNode listNode1, ListNode listNode2) {
//        ListNode listNodeNow = listNode1.next;
        if(listNode1==null){
            return listNode2;
        }
        if(listNode2==null){
            return listNode1;
        }
        if (listNode1.val <= listNode2.val) {
            listNode1.next = check(listNode1.next,listNode2);
            return listNode1;
        }else{
            listNode2.next = check(listNode1,listNode2.next);
            return listNode2;
        }
    }

    public static void main(String[] args) {
//        int[] ints = new int[]{1, 2, 3};
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode lists = new Num21合并两个有序链表().mergeTwoLists(l1, l2);
//        Constants.pringtLinkedList(lists);
    }
}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
