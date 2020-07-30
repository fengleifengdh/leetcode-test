package top.fengleifeng.question;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Num169 {
    public int majorityElement(int[] nums) {
        int numHalf = nums.length/2;
        Map<Integer,Integer> map =new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer in = map.get(nums[i]);
            if(null==in){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],in+1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue()>numHalf){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] i = {2,2,1,1,1,2,2};
        int k = new Num169().majorityElement(i);
        System.out.println(k);
    }
}
