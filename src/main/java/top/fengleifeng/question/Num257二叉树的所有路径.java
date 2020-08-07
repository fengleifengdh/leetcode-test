package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-07 17:07
 **/
public class Num257二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (null == root) {
            return list;
        }
        String str = "";
        check(root, str, list);
        return list;
    }

    void check(TreeNode source, String string, List<String> list) {
        string = string + source.val + "->";
        if (null == source.left && null == source.right) {
            string = string.substring(0, string.length() - 2);
            list.add(string);
        }
        if (null != source.left) {
            check(source.left, new String(string), list);
        }
        if (null != source.right) {
            check(source.right, new String(string), list);
        }
    }

    public static void main(String[] args) {

    }
}
