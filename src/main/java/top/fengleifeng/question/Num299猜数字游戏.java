package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了
 * （称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * <p>
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 * <p>
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * <p>
 * <p>
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 * <p>
 * 通过次数19,164提交次数39,556
 * @author: fengleifeng
 * @create: 2020-09-04 14:43
 **/
public class Num299猜数字游戏 {
    class Solution {
        public String getHint(String secret, String guess) {
            int[] numCount = new int[10];//每一位的数量
            int[] numCountForDel = new int[10];//每一位的数量
            int countA = 0;
            int countB = 0;
            for (int i = 0; i < secret.length(); i++) {
                int num = secret.charAt(i) - '0';
                numCount[num]++;
            }

            for (int i = 0; i < guess.length(); i++) {
                int num = guess.charAt(i) - '0';
                if (secret.charAt(i) == guess.charAt(i)) {
                    countA++;
                    numCount[num]--;
                } else {
                    if (numCount[num] > 0) {
                        numCountForDel[num]++;
                    }
                }
            }
            for (int i = 0; i < numCountForDel.length; i++) {
                if (numCountForDel[i] > 0) {
                    if (numCount[i] > 0) {
                        countB = countB + Math.min(numCount[i], numCountForDel[i]);
//                        numCount[i]--;
                    }
                }
            }
            return countA + "A" + countB + "B";
        }
    }

    public static void main(String[] args) {
//        String secret = "1122", guess = "1222";
//        String secret = "1123";
//        String guess = "0111";
        String secret = "1807";
        String guess = "7810";
        String hint = new Num299猜数字游戏().new Solution().getHint(secret, guess);
        System.out.println(hint);
    }
}
