package top.fengleifeng.question;

import top.fengleifeng.util.Node;

import java.util.Collections;

/**
 * @program: leetcode-test
 * @description: 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-07 17:25
 **/
public class Num559N叉树的最大深度 {
    int max = 0;

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        check(1, root);
        return max;
    }

    void check(int deep, Node root) {
        if (null == root.children || root.children.size() <= 0) {
            max = Math.max(max, deep);
        } else {
            deep++;
            for (int i = 0; i < root.children.size(); i++) {
                check(deep, root.children.get(i));
            }
        }
    }

    public static void main(String[] args) {

    }
}
