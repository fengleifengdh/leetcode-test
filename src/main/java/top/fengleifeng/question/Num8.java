package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-20 10:21
 **/

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num8 {
    public static void main(String[] args) {
//        System.out.println((int) ('+'));
//        System.out.println((int) ('-'));
//        System.out.println((int) ('0'));
//        System.out.println((int) ('9'));
//        System.out.println(Integer.parseInt(String.valueOf('-')));
//        System.out.println(Integer.parseInt(String.valueOf('0')));
//        System.out.println(Integer.parseInt(String.valueOf('9')));
//        System.out.println(new Num8().myAtoi("   45  "));
//        System.out.println(new Num8().myAtoi("   +4 5w  "));
//        System.out.println(new Num8().myAtoi("   +91283472332  "));
//        System.out.println(new Num8().myAtoi("-91283472332"));
//        System.out.println(new Num8().myAtoi("  0000000000012345678"));
//        System.out.println(new Num8().myAtoi("    0000000000000   "));
        System.out.println(new Num8().myAtoi("-000000000000001"));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        Line 39: java.lang.NumberFormatException: For input string: "-91283472332"
//        String str = "-2147483647";
//        String s = str.substring(0, str.length() - 1);
//        int temp = Integer.parseInt(str.substring(str.length() - 1, str.length()));
////        System.out.println(str.substring(str.length() - 1, str.length()));
//        System.out.println(temp);
//        if (Integer.parseInt(s) <= -214748364 && temp > -(Integer.MIN_VALUE % 10)) {
//            System.out.println("1");
//        }
    }
    public int myAtoi2(String str){

        int result = 0;
        int index = 0;
        char[] chars = str.toCharArray();
        int length = chars.length;
         boolean zehngfu= true;//是正是负 true正
         boolean qu0= false;//是正是负 true正

        if(length<=0){
            return 0;
        }
        while (Character.isWhitespace(chars[index])){
            index++;
        }
        if(chars[index]=='-'){
            zehngfu = false;
        }
        if (index == length) {
            return 0;
        }
        for (int i = index+1; i < chars.length; i++) {
            if(zehngfu){
                if(result>Integer.MAX_VALUE/10 ||(result==Integer.MAX_VALUE/10 && chars[i] >Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
            }else{
                if(result<Integer.MIN_VALUE/10 ||(result==Integer.MIN_VALUE/10 && chars[i] >-Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
            }
            result = result*10+chars[i];
        }

        return result;
    }

    public int myAtoi(String str) {
        if(str.length()<=0){
            return 0;
        }
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        int flag = 0;//是否找到第一个非空 0没找到  1第一次找到，2不是第一次
        for (int i = 0; i < chars.length; i++) {
//            if (flag != 0) {
            //先判断是否为空
            if (Character.isWhitespace(chars[i])) {
                if (flag == 2 || flag == 1) {
                    break;
                } else {

                    continue;
                }
            } else {

                if (flag == 1) {
                    flag = 2;
                } else {
                        if(chars[i] =='0'){
                            continue;
                        }
                    flag = 1;
                }
            }
//            }
            if (flag == 1) {
                //判断是否为 +-和数字
                if (chars[i] == 43 || chars[i] == 45 || (chars[i] >= 48 && chars[i] <= 57)) {
                    stringBuilder.append(chars[i]);
                } else {
                    return 0;
                }
            } else if (flag == 2) {
                if (chars[i] >= 48 && chars[i] <= 57) {
                    stringBuilder.append(chars[i]);
                } else {
                    break;
                }
            }
            //

        }

        //去除无效0

        if (stringBuilder.length() > 11) {
            if (stringBuilder.charAt(0) == 45) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (stringBuilder.length() == 11) {
            if (stringBuilder.charAt(0) == 45) {
//                if(stringBuilder.toString().substring(0,stringBuilder.length()-1))
                String s = str.substring(0, str.length() - 1);
                int temp = Integer.parseInt(str.substring(str.length() - 1, str.length()));
                if (Integer.parseInt(s) <= -214748364 && temp > -(Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
            }else if (stringBuilder.charAt(0) == 43) {
                String s = str.substring(0, str.length() - 1);
                int temp = Integer.parseInt(str.substring(str.length() - 1, str.length()));
                if (Integer.parseInt(s) >= 214748364 && temp > (Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
            }else{
                return Integer.MAX_VALUE;
            }
        }else if (stringBuilder.length() == 1){
            if (stringBuilder.charAt(0) == 45 || stringBuilder.charAt(0) == 43 ) {
                return 0;
            }
        }else if(stringBuilder.length() < 1){
            return 0;
        }


        result = Integer.parseInt(stringBuilder.toString());
        return result;
    }
}
