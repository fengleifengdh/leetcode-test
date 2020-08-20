package top.fengleifeng.question;

import org.junit.Test;

import static org.junit.Assert.*;

public class Num41缺失的第一个正数Test {

    @Test
    public void test() {
        int i1 = 0;
        int[] i = {1};
        i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i);
        System.out.println(i1);

        int[] i2 = {1, 2, 0};
        i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i2);
        System.out.println(i1);

        int[] i3 = {1, 1};
        i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i3);
        System.out.println(i1);

        int[] i4 = {3, 4, -1, 1};
        i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i4);
        System.out.println(i1);

        int[] i5 = {2, 2};
        i1 = new Num41缺失的第一个正数().new Solution().firstMissingPositive(i5);
        System.out.println(i1);
    }
}