package top.fengleifeng.util;

public class Constants {

    public static final int[] IntSortOne = {1, 3, 4, 5, 6, 7, 8, 9, 10, 14};// length 10
    public static final int[] IntSortTwo = {1, 4, 6, 6, 7, 7, 8, 8, 10, 11};// length 10

    public static final int[] IntNotSortOne = {2, 5, 16, 21, 51, 10, 1, 11, 4, 23};// length 10
    public static final int[] IntNotSortTwo = {3, 1, 511, 23, 5, 31, 6, 65, 2, 11};// length 10

    public static void printArr(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            System.out.print("[" + intArr[i] + "],");
        }
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
