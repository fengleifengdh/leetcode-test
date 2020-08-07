package top.fengleifeng.question;

import org.junit.Test;

import static org.junit.Assert.*;

public class Num111二叉树的最小深度Test {

    @Test
    public void minDepth() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left  = new TreeNode(9);
        treeNode.right  = new TreeNode(20);
        treeNode.right.left  = new TreeNode(15);
        treeNode.right.right  = new TreeNode(7);
        int result = new Num111二叉树的最小深度().minDepth(treeNode);
        System.out.println(result);
    }
    @Test
    public void minDepth2() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left  = new TreeNode(2);
//        treeNode.right  = new TreeNode(20);
//        treeNode.right.left  = new TreeNode(15);
//        treeNode.right.right  = new TreeNode(7);
        int result = new Num111二叉树的最小深度().minDepth(treeNode);
        System.out.println(result);
    }
}