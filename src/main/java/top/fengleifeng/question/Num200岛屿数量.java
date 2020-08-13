package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode-test
 * @description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 通过次数141,688提交次数283,135
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-13 16:57
 **/
public class Num200岛屿数量 {
    /**
     * 深度优先算法
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid.length<=0||grid[0].length<=0){
            return 0;
        }
        boolean[][] check = new boolean[grid.length][grid[0].length];
        int reuslt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !check[i][j]) {
                    check[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int queueSize = queue.size();
                        for (int k = 0; k < queueSize; k++) {
                            int[] poll = queue.poll();
                            int x = poll[0];
                            int y = poll[1];
                            if (  check(x - 1, y, grid.length, grid[i].length) &&  !check[x - 1][y] && grid[x - 1][y] == '1') {
                                check[x - 1][y] = true;
                                queue.offer(new int[]{x - 1, y});
                            }
                            if (  check(x, y - 1, grid.length, grid[i].length)&& !check[x][y - 1] && grid[x][y - 1] == '1') {
                                check[x][y - 1] = true;
                                queue.offer(new int[]{x, y - 1});
                            }
                            if (  check(x + 1, y, grid.length, grid[i].length)&&!check[x + 1][y] && grid[x + 1][y] == '1') {
                                check[x + 1][y] = true;
                                queue.offer(new int[]{x + 1, y});
                            }
                            if (  check(x, y + 1, grid.length, grid[i].length)&& !check[x][y + 1] && grid[x][y + 1] == '1') {
                                check[x][y + 1] = true;
                                queue.offer(new int[]{x, y + 1});
                            }
                        }
                    }
                    reuslt++;
                }
            }
        }
        return reuslt;
    }

    public boolean check(int x, int y, int limitX, int limitY) {
        return x >= 0 && y >= 0 && x < limitX && y < limitY;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        int ints = new Num200岛屿数量().numIslands(chars);
        System.out.println(ints);
    }
}
