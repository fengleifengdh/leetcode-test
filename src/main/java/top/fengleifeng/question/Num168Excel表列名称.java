package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-08-24 20:46
 **/
public class Num168Excel表列名称 {
    class Solution {
        public String convertToTitle(int n) {
            String result = "";
//            //26进制
//            return check(result, n);

            StringBuilder stringBuilder = new StringBuilder();
            while (n != 0) {
                n--; // 依次获取 26 进制逻辑上的个位、十位、百位…（虽然在 26 进制中不这么叫）
                stringBuilder.append((char) ('A' + n % 26));
                n /= 26;
            }
            return stringBuilder.reverse().toString();

        }

//        String check(String s, int num) {
//            int jingwei = num / 26;
//            int benwei = num % 26;
//            char ch = (char) ('A' + benwei-1);
//            s = ch + s;
//            if (jingwei > 0) {
//                return check(s, jingwei);
//            } else {
//                return s;
//            }
//        }
    }

    public static void main(String[] args) {
        String s = new Num168Excel表列名称().new Solution().convertToTitle(26);
        System.out.println(s);
    }
}
