package top.fengleifeng.question;

import top.fengleifeng.util.ListNode;

/**
 * @program: leetcode-test
 * @description: 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 16:51
 **/
public class Num141环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slower = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slower = slower.next;
            if (fast == slower) {
                return true;
            }
        }
        return false;
    }
}
