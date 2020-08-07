package top.fengleifeng.question;

import top.fengleifeng.util.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode-test
 * @description: 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * @author: fengleifeng
 * @create: 2020-08-07 17:47
 **/
public class Num589N叉树的前序遍历 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (null == root) {
            return list;
        }
        check(root, list);
        return list;
    }

    void check(Node root, List<Integer> list) {
        list.add(root.val);
        if (null == root.children || root.children.size() <= 0) {
            return;
        }else{
            for (int i = 0; i < root.children.size(); i++) {
//                list.add(root.children.get(i).val);
                check(root.children.get(i),list);
            }
        }
    }

}
