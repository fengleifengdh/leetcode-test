package top.fengleifeng.other.算法;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-26 19:54
 **/
public class 字符串转整数 {

    public static void main(String[] args) {
        System.out.println(getInt("3423234"));
    }

    public static Integer getInt(String str) {
//        看实现
        Integer integer = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            integer = integer * 10 + (chars[i] - '0');
        }
        return integer;
    }
}
