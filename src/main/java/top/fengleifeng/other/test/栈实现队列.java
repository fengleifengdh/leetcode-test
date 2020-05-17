package top.fengleifeng.other.test;

import java.util.Stack;

public class 栈实现队列 {

    public static void main(String[] args) {
        final CustomQueue<Integer> customQueue = new CustomQueue<Integer>();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    Integer m = customQueue.deque();
                    if (m != null) {
                        System.out.println(m);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    customQueue.enque(i + 1);
                }
                System.out.println(customQueue.stack1.toString());

            }
        }).start();


    }
}

class CustomQueue<T> {
    public Stack<T> stack1 = new Stack<T>();
    public Stack<T> stack2 = new Stack<T>();

    public synchronized void enque(T item) {

        stack1.push(item);
    }

    public synchronized T deque() {

        T result = null;
        //把S1的元素倒入
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //弹出S2栈顶元素
        if (!stack2.isEmpty()) {
            result = stack2.pop();
        }
        //把S2的元素倒回
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;

    }
}


class CustomQueue2<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public synchronized void enque(T item) {

        stack1.push(item);
    }

    public synchronized T deque() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return null;

    }

}
