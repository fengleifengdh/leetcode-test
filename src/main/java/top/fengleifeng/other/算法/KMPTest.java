package top.fengleifeng.other.算法;

public class KMPTest {

    public static void main(String[] args) {
        System.out.println(getStr("asda21","asdas"));
    }

    /**
     * @param s1 元字符串
     * @param s2 为模式字符串
     * @return
     */
    public static Integer getStr(String s1, String s2) {

        if (s1.length() < s2.length() || s2.length() == 0 || null == s2) return -1;


        Integer result = 0;
        int length1 = s1.length();
        int length2 = s2.length();
        int[] next = new int[length2];
        next[0] = -1;

        //kmp中next数组计算

        for (int i = 1, k = -1; i < s2.length(); i++) {
            if (k == -1 || s2.charAt(i - 1) == s2.charAt(k)) {
                k++;
                next[i] = k;
            } else {
                next[i] = 0;
                k = 0;
            }
        }
        //进行匹配
        for(int i=0,j=0;i<length1;){
            if(length1-i+1<length1 && j==0) return -1;
            if(s1.charAt(i)!=s2.charAt(j)){
                if(next[j]==-1) i++;
                else j=next[j];
            }
            else{
                if(j==s2.length()-1) return i-s2.length()+1;
                i++;j++;
            }
        }
        return -1;
    }
}
