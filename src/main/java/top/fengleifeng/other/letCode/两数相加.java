package top.fengleifeng.other.letCode;

public class 两数相加 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param first
     * @param second
     * @return
     */
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;
        ListNode one = first, two = second;
        ListNode lastbrfor = listNode;
        int add = 0;
        while (one != null || two != null) {

            int x = (one != null) ? one.val : 0;
            int y = (two != null) ? two.val : 0;

            int sum = x + y + add;
            int temp = sum / 10;
            int now = sum % 10;
            add = temp;
            lastbrfor = curr;
            curr.val = now;
            curr.next = new ListNode(add);

            curr = curr.next;
            if (one != null) one = one.next;
            if (two != null) two = two.next;
        }
        if (curr.val == 0 && add == 0) {
            lastbrfor.next = null;
        }
        if (add > 0 && (null != one) && (null != two)) {
            curr.next = new ListNode(add);
        }

        return listNode;
    }


    public static void main(String[] args) {
        /**
         * [2,4,3]
         * [5,6,4]
         */

        ListNode listNode = new ListNode(1);
        ListNode listNode11 = listNode;
        System.out.print(listNode.val + ",");
        for (int i = 0; i < 1; i++) {
            int k = (int) (Math.random() * 1 + 7);
            listNode11.next = new ListNode(k);
            listNode11 = listNode11.next;
            System.out.print(k + ",");
        }
        System.out.println();
        ListNode listNode2 = new ListNode(1);
        ListNode listNode211 = listNode2;
        System.out.print(listNode2.val + ",");

        for (int i = 0; i < 1; i++) {
            int k = (int) (Math.random() * 1 + 7);
            listNode211.next = new ListNode(k);
            listNode211 = listNode211.next;
            System.out.print(k + ",");
        }
        System.out.println();
        ListNode ll = new 两数相加().addTwoNumbers(listNode, listNode2);

        for (int i = 0; ll != null; ll = ll.next) {
            System.out.print(ll.val + ",");
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
