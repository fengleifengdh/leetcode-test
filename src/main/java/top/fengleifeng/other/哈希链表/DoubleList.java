package top.fengleifeng.other.哈希链表;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-28 17:12
 **/
public class DoubleList {
    public Node first;
    public Node end;
    int size = 0;

    public DoubleList() {
        this.first = null;
        this.end = null;
    }

    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x) {
        if (null == first) {
            first = x;
        } else {
            x.next = first;
            x.prve = null;
            first.prve = x;
            first = x;
        }
        if (null == end) {
            end = first;
        }
        size++;
    }

    // 删除链表中的 x 节点(x 一定存在)
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {
        Node node = first;
        //判断是否是头或者尾
        if (x == first) {
            first = x.next;
        }
        if (x == end) {
            end = x.prve;
        }

        while (node != x) {
            node = node.next;
        }
        Node pre = node.prve;
        Node next = node.next;
        if (null != pre) {
            pre.next = next;
            next.prve = pre;
        }


        size--;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast() {
        Node node = end;
        if (end == first) {
            first = null;
        }
        if (null != node) {
            end = end.prve;
            end.next = null;
        } else {
            end = null;
        }
        size--;
        return node;
    }

    // 返回链表⻓度，时间 O(1)
    public int size() {
        return size;
    }
}
