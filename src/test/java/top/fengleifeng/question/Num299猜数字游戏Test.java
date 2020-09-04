package top.fengleifeng.question;

import org.junit.Test;

import static org.junit.Assert.*;

public class Num299猜数字游戏Test {

    @Test
    public void te() {
        String secret = "1807";
        String guess = "7810";
        String hint = new Num299猜数字游戏().new Solution().getHint(secret, guess);
        System.out.println(hint);
    }

    @Test
    public void te2() {
        String secret = "1122", guess = "1222";
        String hint = new Num299猜数字游戏().new Solution().getHint(secret, guess);
        System.out.println(hint);
    }

    @Test
    public void te22() {
        String secret = "1123";
        String guess = "0111";
        String hint = new Num299猜数字游戏().new Solution().getHint(secret, guess);
        System.out.println(hint);
    }
    @Test
    public void te212() {
        String secret = "1122";
        String guess = "2211";
        String hint = new Num299猜数字游戏().new Solution().getHint(secret, guess);
        System.out.println(hint);
    }
}