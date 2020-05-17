import java.util.HashMap;

public class DPTest {

    public static void main(String[] args) {
        System.out.println(f(27));
        System.out.println("");
    }

    static HashMap<Integer, Integer> hashMap = new HashMap();

    public static int f(int num) {

        int result = 1000;
        if (num < 0) {
            return 1000;
        }       if (num == 0) {
            return 0;
        }
//        if (num >= 2) {
        Integer num2 = hashMap.get(num - 2);
        Integer num5 = hashMap.get(num - 5);
        Integer num7 = hashMap.get(num - 7);

        if (null == num2) {
            num2 = f(num - 2) + 1;
            hashMap.put(num - 2, num2);
        }
        if (null == num5) {
            num5 = f(num - 5) + 1;
            hashMap.put(num - 5 ,num5);
        }
        if (null == num7) {
            num7 = f(num - 7) + 1;
            hashMap.put(num - 7, num7);
        }

        int k2 = num2;
        int k5 = num5;
        int k7= num7;


        result = Math.min(k5, k2);
        result = Math.min(k2, k7);

        return result;
    }
}
