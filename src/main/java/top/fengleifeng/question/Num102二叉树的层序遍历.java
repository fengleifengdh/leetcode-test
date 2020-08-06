package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-06 19:07
 **/
public class Num102二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(one);
        }
        return result;
    }

}
