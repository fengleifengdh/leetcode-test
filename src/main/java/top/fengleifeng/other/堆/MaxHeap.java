package top.fengleifeng.other.堆;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-28 15:55
 **/
public class MaxHeap {
    private int[] data;//用数组存储数据
    private int size;//数组大小
    private int capacity;//堆得最大容量

    public MaxHeap(int capacity) {
        this.size = 0;
        data = new int[capacity + 1];
        this.capacity = capacity;
    }

    //向堆里面插入元素
    public void insert(int d) {
        if (size == capacity) {
            System.out.println("堆已满！");
            return;
        }
        //索引为0的位置不存放元素
        data[size + 1] = d;
        size++;
        //插入在最后的元素上移方法
        shiftUp(size);
    }

    private void shiftUp(int i) {
        //数组可能越界问题始终不能忽视
        //当此元素比父元素大时，交换这两个元素位置
        while (i > 1 && data[i] > data[i / 2]) {
            int t = data[i];
            data[i] = data[i / 2];
            data[i / 2] = t;
            i /= 2;
        }

    } //删除堆的最大元素

    public int deleteMax() {
        if (size == 0) {
            System.out.println("堆已经是空的了！");
            return -1;
        }
        int t = data[1];
        //将最后一个元素放到第一个元素位置
        data[1] = data[size];
        size--;
        //然后将第一个元素下移到适当位置
        shiftDown(1);
        data[size+1] = 0;
        return t;
    }


    //堆删除元素时的元素下移
    private void shiftDown(int i) {
        // TODO Auto-generated method stub
        while (2 * i <= size) {
            // 将要将data[i]与data[j]交换
            int j = 2 * i;
            // 让j指向他的孩子结点中的大的那一个
            if (j + 1 <= size && data[j] < data[j + 1]) {
                j += 1;
            }
            if (data[i] > data[j]) {
                break;
            }
            //元素下移
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
            i = j;
        }
    }

}
