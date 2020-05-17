package top.fengleifeng.other.test;

public class 字符串翻转 {

    public static void main(String[] args) {
        String a ="123456";
//        System.out.println(a.);
        int length = a.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a.charAt(length-i-1));
        }
        System.out.println(stringBuilder.toString());


        //第二种
        System.out.println(new StringBuilder(a).reverse());
    }
}
