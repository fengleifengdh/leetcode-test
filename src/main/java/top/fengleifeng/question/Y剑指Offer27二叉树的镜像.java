package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-07 16:42
 **/
public class Y剑指Offer27二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if(null==root){
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        check(root, result);
        return result;
    }

    void check(TreeNode source, TreeNode now) {
        if (null != source.right) {
            now.left = new TreeNode(source.right.val);
            check(source.right,now.left);
        }
        if (null != source.left) {
            now.right = new TreeNode(source.left.val);
            check(source.left,now.right);
        }
    }
}
