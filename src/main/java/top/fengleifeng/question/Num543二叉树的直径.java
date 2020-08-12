package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *  
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 *  
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 这道题的意思是树的左右子树的高度之和，根节点为0，没有左右子树
 * @author: fengleifeng
 * @create: 2020-08-06 19:41
 **/
public class Num543二叉树的直径 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    public int deep(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        int deep = left + right;
        max = Math.max(deep, max);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
        int i = new Num543二叉树的直径().diameterOfBinaryTree(root);
        System.out.println(i);
    }
}
