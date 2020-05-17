package top.fengleifeng.other.letCode.单利;

public class Single {

    private static volatile Single instance;

    private Single() {
    }

    public Single getInstance() {
        if (null == instance) {
            synchronized (Single.class){
                if(null ==instance){
                    instance=new Single();
                }
            }
        }
        return instance;
    }
}
