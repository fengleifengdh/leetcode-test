package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 * 1
 * / \
 * 2 - 3
 * 示例 2：
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 * |   |
 * 4 - 3
 * 注意:
 * <p>
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 * 更新(2017-09-26):
 * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 * <p>
 * 通过次数16,563提交次数27,588
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-20 17:32
 **/
public class Num684冗余连接 {
    /**
     * 思路：
     * 用并查集来处理
     */
    class Solution {
        public class UnionFind {
            int[] parent;
            int[] rank;

            public UnionFind(int total) {
                parent = new int[total];
                rank = new int[total];

                for (int i = 0; i < total; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            public int find(int x) {
                while (x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void unionElements(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);

                if (pRoot == qRoot) {
                    return;
                }

                if (rank[pRoot] < rank[qRoot]) {
                    parent[pRoot] = qRoot;
                } else if (rank[pRoot] > rank[qRoot]) {
                    parent[qRoot] = pRoot;
                } else {
                    parent[pRoot] = qRoot;
                    rank[qRoot] += 1;
                }
            }
        }

        public int[] findRedundantConnection(int[][] edges) {
            int[] res = new int[2];
            UnionFind unionFind = new UnionFind(edges.length);

            // 第一条边肯定未记录至树中，可直接合并节点
            unionFind.unionElements(edges[0][0] - 1, edges[0][1] - 1);
            for (int i = 1; i < edges.length; i++) {
                if (unionFind.find(edges[i][0] - 1) == unionFind.find(edges[i][1] - 1)) {
                    res[0] = edges[i][0];
                    res[1] = edges[i][1];
                } else {
                    unionFind.unionElements(edges[i][0] - 1, edges[i][1] - 1);
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {

    }
}
