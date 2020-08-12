package top.fengleifeng.question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description: 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，
 * 1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * @author: fengleifeng
 * @create: 2020-08-12 16:39
 **/
public class Num1162地图分析 {
    /**
     * bfs多源
     * 广度优先多源
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int gridLength = grid.length;
        //方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //访问过得节点
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        //将海洋加入
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //只有海洋和陆地
        int size = queue.size();
        if (size == 0 || size == gridLength * gridLength) {
            return -1;
        }
        //循环广度搜索
        int deep = -1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] now = queue.poll();
                int currentX = now[0];
                int currentY = now[1];
                for (int j = 0; j < directions.length; j++) {
                    int x = currentX + directions[j][0];
                    int y = currentY + directions[j][1];
                    if (validArea(x, y, gridLength) && grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            deep++;
        }
        return deep--;
    }

    public boolean validArea(int x, int y, int n) {
        return x < n && x >= 0 && y < n && y >= 0;
    }

    public static void main(String[] args) {
        // int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int res = new Num1162地图分析().maxDistance(grid);
        System.out.println(res);
    }
}
