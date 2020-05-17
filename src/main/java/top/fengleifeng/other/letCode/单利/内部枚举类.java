package top.fengleifeng.other.letCode.单利;

public class 内部枚举类 {

    private static class aaaa{
        private static  final 内部枚举类 zzz = new 内部枚举类();
    }
    private 内部枚举类(){}
    public static 内部枚举类 getInstance(){
        return aaaa.zzz;
    }
}
