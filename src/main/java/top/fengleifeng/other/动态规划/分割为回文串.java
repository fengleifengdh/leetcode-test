package top.fengleifeng.other.动态规划;

public class 分割为回文串 {
    public static void main(String[] args) {
        System.out.println(getStr("abbab"));
        String str = "11123";
//        System.out.println(str.substring());
    }

    // 11122232232
    public static int getStr(String str1) {

        int n = str1.length();
        char[] strChar = str1.toCharArray();
        int f[] = new int[n];
        f[0] = 1;


        for (int i = 1; i < n; i++) {
            f[i] = Integer.MIN_VALUE;
            //判断是否为回文串
            for (int j = 0; j < i; j++) {
                String temp = str1.substring(j, i+1);
                boolean flag = isPalindrome(temp);
                if (flag) {
                    f[i] = Math.max(f[i], f[j]);
                    break;
                } else {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            //不是+1
//            f[i] = f[i - 1] + 1;
        }
        return f[n - 1];
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
