package top.fengleifeng.question;

import org.junit.Test;
import top.fengleifeng.util.Node;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Num559N叉树的最大深度Test {

    @Test
    public void maxDepth() {
        Node node = new Node(1, new LinkedList<Node>() {{
            add(new Node(3, new LinkedList<Node>() {{
                add(new Node(7));
                add(new Node(8));
            }}));
            add(new Node(4));
            add(new Node(5));
        }});
        int i = new Num559N叉树的最大深度().maxDepth(node);
        System.out.println(i);
    }
}