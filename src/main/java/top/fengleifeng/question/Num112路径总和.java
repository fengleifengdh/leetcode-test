package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-07 10:16
 **/
public class Num112路径总和 {
    /**
     * 思路：
     * 判断一个节点是叶子节点，他的左右子节点都是空节点
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int treeNodeSum = 0;
        return check(root, treeNodeSum, sum);
    }

    boolean check(TreeNode now, int treeNodeSum, int sum) {
        //判断是叶子节点
        treeNodeSum = treeNodeSum + now.val;
        if (now.left == null && now.right == null) {
            if (treeNodeSum == sum) {
                return true;
            } else {
                return false;
            }
        } else if (now.left == null) {
            return check(now.right, treeNodeSum, sum);
        } else if (now.right == null) {
            return check(now.left, treeNodeSum, sum);
        } else {
            boolean left = check(now.left, treeNodeSum, sum);
            if (left) {
                return true;
            } else {
                return check(now.right, treeNodeSum, sum);
            }
        }
    }
}
