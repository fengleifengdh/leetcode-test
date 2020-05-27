package top.fengleifeng.util;

import top.fengleifeng.总结.树.TreeNode;

public class Constants {
    public static final int[][] IntTwoArrSortOne = {{1,2},{3,4},{7,3},{3,2},{88,8}};
    public static final int[] IntSortOne = {1, 3, 4, 5, 6, 7, 8, 9, 10, 14};// length 10
    public static final int[] IntSortTwo = {1, 4, 6, 6, 7, 7, 8, 8, 10, 11};// length 10

    public static final int[] IntNotSortOne = {2, 5, 16, 21, 51, 10, 1, 11, 4, 23};// length 10
    public static final int[] IntNotSortTwo = {3, 1, 511, 23, 5, 31, 6, 65, 2, 11};// length 10

    public static TreeNode treeNode;

    static {
        treeNode = new TreeNode("1");
        TreeNode treeNode2 = new TreeNode("2");
        TreeNode treeNode3 = new TreeNode("3");
        TreeNode treeNode4 = new TreeNode("4");
        TreeNode treeNode5 = new TreeNode("5");
        TreeNode treeNode6 = new TreeNode("6");
        TreeNode treeNode7 = new TreeNode("7");
        TreeNode treeNode8 = new TreeNode("8");

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;
    }

    public static void printArr(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            System.out.print("[" + intArr[i] + "],");
        }
        System.out.println();
    }

    public static void printArr(Integer[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            System.out.print("[" + intArr[i] + "],");
        }
        System.out.println();
    }

    public static void printArrs(int[][] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[0].length; j++) {
                System.out.print("[" + intArr[i][j] + "],");
            }
            System.out.println("");
        }
        System.out.println("------");
    }

    public static int[][] copy2Arr(int[][] source) {
        int[][] target = new int[source.length][source[0].length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                target[i][j] = source[i][j];
            }
        }
        return target;
    }

}
