package top.fengleifeng.other.动态规划;

public class 回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int temp = x;
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int k = 0;
        while (x > k) {
            k = k * 10 + x % 10;
            x = x / 10;
        }
//        if()
        return x == k || x ==k/10;
    }

}
