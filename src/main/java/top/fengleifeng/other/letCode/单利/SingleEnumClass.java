package top.fengleifeng.other.letCode.单利;

public class SingleEnumClass {

    private SingleEnumClass(){}

    static enum SingleClass{
        INSTANCE;
        private SingleEnumClass singleEnumClass;
        private SingleClass(){
            singleEnumClass = new SingleEnumClass();
        }
        public SingleEnumClass getSingleEnumClass(){
            return singleEnumClass;
        }
    }

    public static  SingleEnumClass get(){
       return  SingleClass.INSTANCE.getSingleEnumClass();
    }


}
