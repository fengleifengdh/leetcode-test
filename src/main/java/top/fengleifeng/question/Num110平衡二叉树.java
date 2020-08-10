package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-10 10:38
 **/
public class Num110平衡二叉树 {
    /**
     * 思路：
     * 每一个子树的左右节点的深度不超过1
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return checkDeap(root);
//        return defferent > 1;
    }

    boolean checkDeap(TreeNode treeNode) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return true;
        } else {

            int leftdeep = 0;
            int rightdeep = 0;
            if (treeNode.left != null) {
                if(!checkDeap(treeNode.left)){
                    return false;
                }
                leftdeep = getDeap(treeNode.left) + 1;
            }
            if (treeNode.right != null) {
                if(!checkDeap(treeNode.right)){
                    return false;
                }
                rightdeep = getDeap(treeNode.right) + 1;
            }
            int defferent = Math.abs(leftdeep - rightdeep);
            return defferent <= 1;
        }
    }

    int getDeap(TreeNode treeNode) {
        int leftdeep = 0;
        int rightdeep = 0;
        if (treeNode.left != null) {
            leftdeep = getDeap(treeNode.left) + 1;
        }
        if (treeNode.right != null) {
            rightdeep = getDeap(treeNode.right) + 1;
        }
        return Math.max(leftdeep, rightdeep);
    }

//    int checkDeap(TreeNode treeNode) {
//        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
//            return 0;
//        } else {
//            int leftdeep = 0;
//            int rightdeep = 0;
//            if (treeNode.left != null) {
//                leftdeep = checkDeap(treeNode.left) + 1;
//            }
//            if (treeNode.right != null) {
//                rightdeep = checkDeap(treeNode.right) + 1;
//            }
//            int defferent = Math.abs(leftdeep - rightdeep);
//            return defferent;
//        }
//    }

    public static void main(String[] args) {

    }
}
