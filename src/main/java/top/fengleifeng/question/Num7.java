package top.fengleifeng.question;

public class Num7 {
    public static void main(String[] args) {
        System.out.println(new Num7().reverse(1463847412));
    }

    public int reverse(int x) {
        int result = 0;
        boolean flag = false;
        //
        if(x<=-2147483648){
            return 0;
        }
        if (x < 0) {
            flag = true;
            x = -x;
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int k = x % 10;

            //判断是否溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && k > 7))
                return 0;


            result = result * 10 + k;
            if (x < 10) {
                if (flag) {
                    result = result * -1;
                }
                return result;
            }
            x = x / 10;
        }
        return -1;
    }
}
