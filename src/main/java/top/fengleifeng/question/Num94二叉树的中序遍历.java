package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 17:33
 **/
public class Num94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        check(root, list);
        return list;
    }

    public void check(TreeNode root, List<Integer> list) {
        if (null != root) {
            check(root.left, list);
            list.add(root.val);
            check(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
         root.right = new TreeNode(2);
         root.right.left = new TreeNode(4);
        List<Integer> list = new Num94二叉树的中序遍历().inorderTraversal(root);
        Constants.pringLinkedList(list);
    }

}
