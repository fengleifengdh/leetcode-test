package top.fengleifeng.question;


public class Num2 {

    public static void main(String[] args) {
        /**
         * [2,4,3]
         * [5,6,4]
         */

        ListNode2 ListNode2 = new ListNode2(1);
        ListNode2 ListNode211 = ListNode2;
        System.out.print(ListNode2.val + ",");
        for (int i = 0; i < 1; i++) {
            int k = (int) (Math.random() * 1 + 7);
            ListNode211.next = new ListNode2(k);
            ListNode211 = ListNode211.next;
            System.out.print(k + ",");
        }
        System.out.println();
        ListNode2 ListNode22 = new ListNode2(1);
        ListNode2 ListNode2211 = ListNode22;
        System.out.print(ListNode22.val + ",");

        for (int i = 0; i < 1; i++) {
            int k = (int) (Math.random() * 1 + 7);
            ListNode2211.next = new ListNode2(k);
            ListNode2211 = ListNode2211.next;
            System.out.print(k + ",");
        }
        System.out.println();
        ListNode2 ll = new Num2().addTwoNumbers(ListNode2, ListNode22);

        for (int i = 0; ll != null; ll = ll.next) {
            System.out.print(ll.val + ",");
        }
        System.out.println();
    }


    public ListNode2 addTwoNumbers(ListNode2 first, ListNode2 second) {
        ListNode2 ListNode2 = new ListNode2(0);
        ListNode2 curr = ListNode2;
        ListNode2 one = first, two = second;
        ListNode2 lastbrfor = ListNode2;
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
            curr.next = new ListNode2(add);

            curr = curr.next;
            if (one != null) one = one.next;
            if (two != null) two = two.next;
        }
        if (curr.val == 0 && add == 0) {
            lastbrfor.next = null;
        }
        if (add > 0 && (null != one) && (null != two)) {
            curr.next = new ListNode2(add);
        }
        return ListNode2;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
    }
}
