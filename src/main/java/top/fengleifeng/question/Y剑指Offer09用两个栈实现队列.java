package top.fengleifeng.question;

import java.util.Stack;

/**
 * @program: leetcode-test
 * @description:用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 通过次数79,823提交次数108,735
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-24 20:15
 **/
public class Y剑指Offer09用两个栈实现队列 {

    class CQueue {
        Stack<Integer> one = new Stack();//放入数据
        Stack<Integer> two = new Stack();
        boolean flag = true;//数据在one还是two ,one存 two取

        public CQueue() {

        }

        public void appendTail(int value) {
            if (!flag) {
                int twosize = two.size();
                for (int i = 0; i < twosize; i++) {
                    one.push(two.pop());
                }
                flag = true;
            }
            one.push(value);

            System.out.println("塞入" + value);
        }

        public int deleteHead() {
            if (flag) {
                int onesize = one.size();
                for (int i = 0; i < onesize; i++) {
                    two.push(one.pop());
                }
                flag = false;
            }
            if(two.size()<=0){
                return -1;
            }
            int pop = two.pop();
            System.out.println("弹出" + pop);
            return pop;
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new Y剑指Offer09用两个栈实现队列().new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.deleteHead();
        cQueue.deleteHead();
        System.out.println();
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
