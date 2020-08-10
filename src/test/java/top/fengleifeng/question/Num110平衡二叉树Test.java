package top.fengleifeng.question;

import org.junit.Test;

import static org.junit.Assert.*;

public class Num110平衡二叉树Test {

    @Test
    public void isBalanced() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left  = new TreeNode(9);
        treeNode.right  = new TreeNode(20);
        treeNode.right.left  = new TreeNode(15);
        treeNode.right.right  = new TreeNode(7);
        boolean result = new Num110平衡二叉树().checkDeap(treeNode);
        System.out.println(result);
    }  @Test
    public void isBalanced2() {
        //[1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left  = new TreeNode(2);
        treeNode.right  = new TreeNode(3);
        treeNode.left.left  = new TreeNode(4);
        treeNode.left.right  = new TreeNode(5);
//        treeNode.right.left  = new TreeNode();
        treeNode.right.right  = new TreeNode(6);
        treeNode.left.left.left  = new TreeNode(7);
        treeNode.right.right.right  = new TreeNode(8);

        boolean result = new Num110平衡二叉树().checkDeap(treeNode);
        System.out.println(result);
    }
}