package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import static org.junit.Assert.*;

public class Num566重塑矩阵Test {

    @org.junit.Test
    public void matrixReshape() {
        int[][] int1 = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] ints = new Num566重塑矩阵().matrixReshape(int1, r, c);
        Constants.printArrs(ints);
    }
    @org.junit.Test
    public void matrixReshape2() {
        int[][] int1 = {{1},{2},{3},{4}};
        int r = 2;
        int c = 2;
        int[][] ints = new Num566重塑矩阵().matrixReshape(int1, r, c);
        Constants.printArrs(ints);
    }
}