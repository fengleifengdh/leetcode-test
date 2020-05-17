package top.fengleifeng.other.letCode;

public class 最长子串 {

    public int lengthOfLongestSubstring11(String s) {
        if(null==s ||s.length()<=0){
            return 0;
        }
        int result = 1;
        int tempResult = result;
        String stemp = String.valueOf(s.charAt(0));
        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (stemp.contains(String.valueOf(arr[i]))) {
                if (tempResult > result) {
                    result = tempResult;
                }
                tempResult = 1;
                stemp = String.valueOf(arr[i]);
            } else {
                stemp = stemp + String.valueOf(arr[i]);
                tempResult++;
            }

        }
        if (tempResult > result) {
            result = tempResult;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new 最长子串().lengthOfLongestSubstring("dvdf"));
        System.out.println(new 最长子串().lengthOfLongestSubstring("au"));
    }


    public int lengthOfLongestSubstring(String s ){
        if(null==s ||s.length()<=0){
            return 0;
        }
        int result = 1;
        int tempResult = result;
        String stemp = null;
        char[] arr = s.toCharArray();
        for (int k = 0; k <arr.length-1 ; k++) {
             stemp = String.valueOf(s.charAt(k));
            for (int i = k+1; i <arr.length ; i++) {
                if (stemp.contains(String.valueOf(arr[i]))) {
                    if (tempResult > result) {
                        result = tempResult;
                    }
                    tempResult = 1;
                    break;
                }else{
                    stemp = stemp + String.valueOf(arr[i]);
                    tempResult++;
                }
            }
            if (tempResult > result) {
                result = tempResult;
            }
            tempResult = 1;
        }

        if (tempResult > result) {
            result = tempResult;
        }
        return result;
    }
}
