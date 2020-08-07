package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-06 17:08
 **/
public class Num572另一个树的子树 {
//    boolean reuslt = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        return check(s, t);
    }

    boolean check(TreeNode s, TreeNode object) {
        boolean result = isSameTree(s, object);
        if (result) {
            return true;
        }else{
            if(null!=s.left){
                boolean check = check(s.left, object);
                if(check){
                    return true;
                }
            }
            if(null!=s.right){
                boolean check = check(s.right, object);
                if(check){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {

    }
}
