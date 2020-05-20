package top.fengleifeng.question;

public class Num9 {
    public static void main(String[] args) {
        System.out.println(new Num9().isPalindrome(1001));
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String str = x+"";
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i)==str.charAt(str.length()-i-1)){

            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        // String str = x+"";
        // for (int i = 0; i < str.length(); i++) {
        //     if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        //         return false;
        //     }
        // }
        //  return true;

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
