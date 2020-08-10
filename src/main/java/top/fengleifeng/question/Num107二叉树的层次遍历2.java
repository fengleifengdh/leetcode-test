package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description: 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 通过次数73,518提交次数111,051
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-07 18:11
 **/
public class Num107二叉树的层次遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            int i = treeNodeQueue.size();//这一层有几个
            List<Integer> one = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                TreeNode treeNode = treeNodeQueue.poll();
                one.add(treeNode.val);
                if (null != treeNode.left) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            result.add(0, one);
        }
        return result ;
    }
}
