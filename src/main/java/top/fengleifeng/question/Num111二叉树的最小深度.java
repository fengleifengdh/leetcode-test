package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-07 15:21
 **/
public class Num111二叉树的最小深度 {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        check(1, root);
        return min;
    }

    void check(int deep, TreeNode root) {
        if (root.right == null && root.left == null) {
            min = Math.min(min, deep);
        } else {
            deep++;
            if (root.left != null) {
                check(deep, root.left);
            }
            if (root.right != null) {
                check(deep, root.right);
            }
        }
    }

}
