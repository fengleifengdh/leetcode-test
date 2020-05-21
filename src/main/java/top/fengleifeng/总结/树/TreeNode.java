package top.fengleifeng.总结.树;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-21 16:21
 **/
@Data
@AllArgsConstructor
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String name;

    public TreeNode(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode("1");
        TreeNode treeNode2 = new TreeNode("2");
        TreeNode treeNode3 = new TreeNode("3");
        TreeNode treeNode4 = new TreeNode("4");
        TreeNode treeNode5 = new TreeNode("5");
        TreeNode treeNode6 = new TreeNode("6");
        TreeNode treeNode7 = new TreeNode("7");
        TreeNode treeNode8 = new TreeNode("8");

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;
        System.out.print("前序递归：");
        treeNode1.preorderTraversal(treeNode1);
        System.out.println();
        System.out.print("前序非递归：");
        treeNode1.preorderTraversal2(treeNode1);

        System.out.print("中序递归：");
        treeNode1.inorderTraversal(treeNode1);
        System.out.println();
        System.out.print("前序非递归：");
        treeNode1.inorderTraversal2(treeNode1);

        System.out.print("后序递归：");
        treeNode1.postorderTraversal(treeNode1);
        System.out.println();
        System.out.print("后序非递归：");
        treeNode1.postorderTraversal2(treeNode1);
        System.out.println();

        System.out.print("层次非递归：");
        treeNode1.LevelTraversal(treeNode1);
    }
    /**
     * 二叉树遍历
     * 三种遍历
     * 前序遍历：中 左 右
     * 中序遍历：左 中 右
     * 后序遍历：左 右 中
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树 ---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：只需按层次遍历即可
     */
    /**
     * 前序遍历 递归版本
     */
    public void preorderTraversal(TreeNode node) {
        if (null != node) {
            System.out.print(node.name + ",");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    /**
     * 前序遍历 非递归版本
     */
    public void preorderTraversal2(TreeNode node) {
        Stack<TreeNode> treeNodes = new Stack<>();
        while (node != null || !treeNodes.isEmpty()) {
            if (null != node) {
                System.out.print(node.name + ",");
                treeNodes.push(node);
                node = node.left;
            } else {
                TreeNode treeNode = treeNodes.pop();
                node = treeNode.right;
            }
        }
        System.out.println();
    }
    /**
     * 中序遍历 递归版本
     */
    public void inorderTraversal(TreeNode node) {
        if (null != node) {
            inorderTraversal(node.left);
            System.out.print(node.name + ",");
            inorderTraversal(node.right);
        }
    }
    /**
     * 前序遍历 非递归版本
     */
    public void inorderTraversal2(TreeNode node) {
        Stack<TreeNode> treeNodes = new Stack<>();
        while (node != null || !treeNodes.isEmpty()) {
            if (null != node) {
                treeNodes.push(node);
                node = node.left;
            } else {
                TreeNode treeNode = treeNodes.pop();
                System.out.print(treeNode.name + ",");
                node = treeNode.right;
            }
        }
        System.out.println();
    }
    /**
     * 后序遍历 递归版本
     */
    public void postorderTraversal(TreeNode node) {
        if (null != node) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.name + ",");
        }
    }

    /**
     * 后序遍历 非递归版本 TODO
     */
    public void postorderTraversal2(TreeNode node) {
//        Stack<TreeNode> treeNodes = new Stack<>();
//        while (node != null || !treeNodes.isEmpty()) {
//            if (null != node) {
//                treeNodes.push(node);
//                node = node.left;
//            } else {
//                TreeNode treeNode = treeNodes.pop();
//                System.out.print(treeNode.name + ",");
//                node = treeNode.right;
//            }
//        }
//        System.out.println();
    }
    /**
     * 层次遍历 用队列的方式遍历
     */
    public void LevelTraversal(TreeNode node){
        Queue<TreeNode>  treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node);
        while (!treeNodeQueue.isEmpty()){
            TreeNode now = treeNodeQueue.poll();
            System.out.print(now.name + ",");
            if(null!=now.left){
                treeNodeQueue.add(now.left);
            }
            if(null!=now.right){
                treeNodeQueue.add(now.right);
            }
        }
    }
}
