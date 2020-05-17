package top.fengleifeng.other.动态规划;

import java.util.*;

public class 路径最大 {

    public static void main(String[] args) {
        NodeS s = new NodeS(7);
        NodeS s1 = new NodeS(3);
        NodeS s2 = new NodeS(8);
        s.setLeft(s1);
        s.setRight(s2);

        s1.setRightparent(s);
        s2.setLeftparent(s);

        NodeS s3 = new NodeS(8);
        NodeS s4 = new NodeS(1);
        NodeS s5 = new NodeS(0);

        s3.setRightparent(s1);
        s4.setLeftparent(s1);
        s4.setRightparent(s2);
        s5.setLeftparent(s2);

        s1.setLeft(s3);
        s1.setRight(s4);
        s2.setLeft(s4);
        s2.setRight(s5);

        NodeS s6 = new NodeS(2);
        NodeS s7 = new NodeS(7);
        NodeS s8 = new NodeS(4);
        NodeS s9 = new NodeS(4);

        s6.setRightparent(s3);
        s7.setLeftparent(s3);
        s7.setRightparent(s4);
        s8.setLeftparent(s4);
        s8.setRightparent(s5);
        s9.setLeftparent(s5);

        s3.setLeft(s6);
        s3.setRight(s7);
        s4.setLeft(s7);
        s4.setRight(s8);
        s5.setLeft(s8);
        s5.setRight(s9);

        NodeS s11 = new NodeS(4);
        NodeS s12 = new NodeS(5);
        NodeS s13 = new NodeS(2);
        NodeS s14 = new NodeS(6);
        NodeS s15 = new NodeS(5);

        s11.setRightparent(s6);
        s12.setLeftparent(s6);
        s12.setRightparent(s7);
        s13.setLeftparent(s7);
        s13.setRightparent(s8);
        s14.setLeftparent(s8);
        s14.setRightparent(s9);
        s15.setLeftparent(s9);


        s6.setLeft(s11);
        s6.setRight(s12);
        s7.setLeft(s12);
        s7.setRight(s13);
        s8.setLeft(s13);
        s8.setRight(s14);
        s9.setLeft(s14);
        s9.setRight(s15);

//        System.out.println(big(s));
        System.out.println(inorderTraversal(s));
    }


    public static int inorderTraversal(NodeS root) {
        int sum = 0;
        Stack<NodeS> tmp = new Stack<>();
        NodeS p = root;
        //p是遍历指针，如果一直有最左边结点，一直遍历； 第二种情况是如果没有最左边结点，就要访问stack中的结点
        while(p!=null || !tmp.isEmpty()) {
            //两种情况
            //第一种情况，来到最左边的结点,最左边的结点肯定是没有左孩子结点
            while (p != null) {
                tmp.add(p);
                p = p.left;
            }

            //判断最左边的结点是否有右结点，继续按照上面的步骤遍历遍历到其最左边的结点
            if (!tmp.isEmpty()) {
                //遍历最左边的结点
                NodeS t = tmp.pop();
                int leftparval = (null == t.getLeftparent()?0:t.getLeftparent().getVal());
                int rightparval = (null == t.getRightparent()?0:t.getRightparent().getVal());
                t.setCount(t.count + Math.max(leftparval,rightparval));
//                result.add(t.val);
                if (t.getCount() > sum) {
                    sum = t.getCount();
                    System.out.println(t.val+":"+leftparval+":"+rightparval+":"+":"+rightparval);
                }
                if (t.right != null)
                    p = t.right;
            }
        }

        return sum;
    }


    //确定状态
    //转移方程
    //边界情况，初始条件
    //计算顺序
    public static int big(NodeS nodeS) {
        NodeS temp = nodeS;

        int[] f = new int[100];
        f[0] = nodeS.getVal();

        int sum = 0;

        while (true) {
            temp = temp.getLeft();
            if(null==temp){
//                temp= temp
            }else if (temp.getLeft() == null) {
                temp = temp.getRight();
            } else if (temp.getRight() == null) {
                break;
            } else {
                int leftparval = (null == temp.getLeftparent()?0:temp.getLeftparent().getVal());
                int rightparval = (null == temp.getRightparent()?0:temp.getRightparent().getVal());
                temp.setCount(temp.count + Math.max(leftparval,rightparval));
                if (temp.getCount() > sum) {
                    sum = temp.getCount();
                }
            }

        }
        System.out.println(sum);
        return sum;
    }


}

class NodeS {
    public NodeS(int val) {
        this.val = val;
    }

    int count;
    int val;
    NodeS leftparent;
    NodeS rightparent;
    NodeS left;
    NodeS right;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NodeS getLeft() {
        return left;
    }

    public void setLeft(NodeS left) {
        this.left = left;
    }

    public NodeS getRight() {
        return right;
    }

    public void setRight(NodeS right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeS getLeftparent() {
        return leftparent;
    }

    public void setLeftparent(NodeS leftparent) {
        this.leftparent = leftparent;
    }

    public NodeS getRightparent() {
        return rightparent;
    }

    public void setRightparent(NodeS rightparent) {
        this.rightparent = rightparent;
    }
}
