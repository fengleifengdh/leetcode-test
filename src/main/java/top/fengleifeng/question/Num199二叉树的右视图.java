package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-19 17:55
 **/
public class Num199二叉树的右视图 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            if(null==root){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode one = queue.poll();
                    if (one.left != null) {
                        queue.add(one.left);
                    }
                    if (one.right != null) {
                        queue.add(one.right);
                    }
                    if (i == size - 1) {
                        list.add(one.val);
                    }
                }
            }
            return list;
        }
    }
}
