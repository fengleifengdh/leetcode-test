package top.fengleifeng.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num17 {

    public static void main(String[] args) {
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v',});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        ArrayList<String> arrayList = new ArrayList<>();
        String s = "23";
        char[] chars = s.toCharArray();
        choose(new StringBuffer(), map, chars, arrayList);
        System.out.println();
    }

    public static void choose(StringBuffer s, Map<Character, Character[]> map, char[] source, ArrayList<String> arrayList) {
//        char[] chars = source.toCharArray();
        if (s.length() == source.length) {
            arrayList.add(s.toString());
            return;
        }
        char c = source[s.length()];
        Character[] characters = map.get(c);
        for (int i = 0; i < characters.length; i++) {
            s.append(characters[i]);
            choose(s,map,source,arrayList);
            s.delete(s.length()-1,s.length());
        }
        return ;
    }















    public List<String> letterCombinations(String digits) {
        if(digits.length()<=0){
            return new  ArrayList<String>();
        }
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v',});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        ArrayList<String> arrayList = new ArrayList<>();
//        String s = "23";
        char[] chars = digits.toCharArray();
        new Num17().choose2(new StringBuffer(), map, chars, arrayList);
        return arrayList;
    }

    public  void choose2(StringBuffer s, Map<Character, Character[]> map, char[] source, ArrayList<String> arrayList) {
//        char[] chars = source.toCharArray();
        if (s.length() == source.length) {
            arrayList.add(s.toString());
            return;
        }
        char c = source[s.length()];
        Character[] characters = map.get(c);
        for (int i = 0; i < characters.length; i++) {
            s.append(characters[i]);
            choose(s,map,source,arrayList);
            s.delete(s.length()-1,s.length());
        }
        return ;
    }
}
