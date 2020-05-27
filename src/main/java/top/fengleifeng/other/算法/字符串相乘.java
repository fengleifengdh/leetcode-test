package top.fengleifeng.other.算法;

import javax.crypto.spec.PSource;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-27 11:23
 **/
public class 字符串相乘 {
    public static void main(String[] args) {
        String s1 = "1111111111";
        String s2 = "1111111111";
//        char i = '0';
//        System.out.println((int) i);
        System.out.println(mlt(s1,s2));
    }
    //0*0  9*9 最多两位

    /**
     * 123*456
     * 把所有字符串分割成1位相乘
     * <p>
     * s1[i] s2[i]
     * 3*6 = 18
     * 12
     * 56
     * 12
     * 6
     * 10
     * 5
     * 662
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String mlt(String s1, String s2) {
//        String result = "";
        char[] resultchar = new char[s1.length() + s2.length()];
        for (int i = 0; i < resultchar.length; i++) {
            resultchar[i] = '0';
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        //s1*s2
        for (int i = s2.length()-1; i >=0; i--) {
            for (int j = s1.length()-1; j>=0; j--) {
                Integer sss = s2.length()-1-i + s1.length()-1-j;
                Integer now = (chars1[j] - '0') * (chars2[i] - '0');//现在的值 2*6 =12
                Integer xianwei = now % 10;//i+j的值  个位值     2*6 中的2
                Integer temp = (resultchar[sss] - '0') + xianwei;//和原来的值相加后
                Integer jinwei = temp / 10;//总共需要进位

                Integer ijtemp = temp % 10;
                resultchar[sss] = (char) (ijtemp + 48);
                stepone(resultchar, sss +1, jinwei);//判断i+j是否进位
            }
        }
        return new StringBuffer().insert(0,resultchar).reverse().toString();
    }

    //向上进位 增加index  增加几
    public static void stepone(char[] source, int index, int num) {
        if (num <= 0|| index==source.length) {
            return;
        }
        Integer now = (source[index] - '0') + num;//现在的值 2*6 =12
        Integer jinwei = now / 10;//总共需要进位
        Integer ijtemp = now % 10;
        source[index] = (char) (ijtemp + 48);
        if (jinwei > 0) {
            stepone(source, index - 1, jinwei);
        }
    }
}
