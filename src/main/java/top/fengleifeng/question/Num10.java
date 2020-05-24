package top.fengleifeng.question;

public class Num10 {
    public static void main(String[] args) {
//        System.out.println(new Num10().isMatch("aab", "c*a*b"));
//        "mississippi"
//        "mis*is*ip*."
//        System.out.println(new Num10().isMatch("mississippi", "mis*is*p*."));
//        System.out.println(new Num10().isMatch("mississippi", "mis*is*ip*."));
        System.out.println(new Num10().isMatch("ab", ".*c"));
    }

    public boolean isMatch(String s, String p) {
//        if()
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        int sIndex = 0;
        int pIndex = 0;
        char pre = 0;
        for (; sIndex < schars.length && pIndex < pchars.length; sIndex++) {
            char stemp = schars[sIndex];
            char ptemp = pchars[pIndex];
            if (ptemp == stemp) {
                pIndex++;
            } else if (ptemp == '.') {
                pIndex++;
            } else if (ptemp == '*' && (pre == '.' || pre == stemp)) {

            } else if ((pIndex + 1 <= pchars.length - 1) && (pchars[pIndex + 1] == '.')) {
                pIndex = pIndex + 1;
            } else if ((pIndex + 1 <= pchars.length - 1) && (pchars[pIndex + 1] == '*')) {
                pIndex = pIndex + 2;
            } else if ((pIndex + 1 <= pchars.length - 1) && (pchars[pIndex + 1] == stemp)) {
                pIndex = pIndex + 2;
            } else {
                return false;
            }
            if (pIndex == pchars.length && sIndex != schars.length - 1) {
                return false;
            }
            if (ptemp == '*') {

            } else {
                pre = ptemp;
            }
        }
        if (pIndex != pchars.length - 1) {
            return false;
        }
        return true;
    }
}
