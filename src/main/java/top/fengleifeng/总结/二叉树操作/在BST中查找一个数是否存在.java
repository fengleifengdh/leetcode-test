package top.fengleifeng.总结.二叉树操作;

import top.fengleifeng.util.Constants;
import top.fengleifeng.总结.树.TreeNode;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-06-02 20:21
 **/
public class 在BST中查找一个数是否存在 {
    public static void main(String[] args) {
        TreeNode treeNode = Constants.treeNode;

    }

    public static boolean bst(TreeNode treeNode, String name) {
        if (null == treeNode) return false;
        if (name == treeNode.name) return true;

        return bst(treeNode.left, name) || bst(treeNode.right, name);
    }
}
