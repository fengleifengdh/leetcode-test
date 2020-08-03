package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-03 17:09
 **/
public class Num101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (null == p && q == null) {
            return true;
        }
        if (null == p || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        boolean result = new Num101对称二叉树().isSymmetric(treeNode);
        System.out.println(result);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}