package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

/**
 * @program: leetcode-test
 * @description: 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 *  
 * <p>
 * 提示：
 * <p>
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-04 10:27
 **/
public class XQuestion0810颜色填充 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length < 0 || image[0].length < 0) {
            return image;
        }
        int sourceColor = image[sr][sc];
        int[][] k = new int[image.length][image[0].length];
        k[sr][sc] = newColor;
        image[sr][sc] = newColor;
        check(image,sr,sc,newColor,k,sourceColor);

        return image;
    }

    public void check(int[][] image, int sr, int sc, int newColor, int[][] k, int sourceColor) {
        //上
        if (sr > 0 && k[sr - 1][sc] != newColor && (image[sr - 1][sc] == sourceColor)) {
            k[sr - 1][sc] = newColor;
            image[sr - 1][sc] = newColor;
            check(image, sr - 1, sc, newColor, k, sourceColor);
        }
        //下
        if (sr < (image.length - 1) && k[sr + 1][sc] != newColor && (image[sr + 1][sc] == sourceColor)) {
            k[sr + 1][sc] = newColor;
            image[sr + 1][sc] = newColor;
            check(image, sr + 1, sc, newColor, k, sourceColor);
        }
        //左
        if (sc > 0 && k[sr][sc - 1] != newColor && (image[sr][sc - 1] == sourceColor)) {
            k[sr][sc - 1] = newColor;
            image[sr][sc - 1] = newColor;
            check(image, sr, sc - 1, newColor, k, sourceColor);
        }
        //右
        if (sc < (image[0].length - 1) && k[sr][sc + 1] != newColor && (image[sr][sc + 1] == sourceColor)) {
            k[sr][sc + 1] = newColor;
            image[sr][sc + 1] = newColor;
            check(image, sr, sc + 1, newColor, k, sourceColor);
        }
        return;
    }


    public static void main(String[] args) {
        int[][] IntSortThree = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };//
        int sr = 0;
        int sc = 0;
        int newColor = 2;
        int[][] result = new XQuestion0810颜色填充().floodFill(IntSortThree, sr, sc, newColor);
        Constants.printArrs(result);
    }
}
