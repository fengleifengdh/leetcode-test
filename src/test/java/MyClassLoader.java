import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String classLoaderName;
    private final String fileExtension = ".class";

    public MyClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    } 

    @Override
    public String toString() {
        return "[" + classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    private byte[] loadClassData (String name) throws Exception{
        InputStream in =  null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] data = null;
        try{
            this.classLoaderName = this.classLoaderName.replace(".","/");
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }
}
