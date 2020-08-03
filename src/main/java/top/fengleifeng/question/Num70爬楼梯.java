package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-03 16:54
 **/
public class Num70爬楼梯 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int reuslt = 0;
        int[] nArr = new int[n];
        nArr[0] = 1;
        nArr[1] = 2;
        for (int i = 2; i < n; i++) {
            nArr[i] = nArr[i - 1] + nArr[i - 2];
        }
        return nArr[n-1];
    }

    public void n(int[] nArr, int n, int sum) {

    }

    public static void main(String[] args) {
//        int[] i = {1};
//        int[] i = {1, 0, 0, 0,0, 1};
        int num = 4;

        int result = new Num70爬楼梯().climbStairs(num);
        System.out.println(result);
    }
}
