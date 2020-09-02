package top.fengleifeng.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @program: leetcode-test
 * @description: 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * 通过次数23,169提交次数87,612
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-09-02 19:20
 **/
public class Num220存在重复元素III {

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                int one = nums[i];
                Integer s = treeSet.ceiling(one);//最小值
                if (s != null && s <= nums[i] + t) {
                    return true;
                }
                Integer g = treeSet.floor(nums[i]);
                if (g != null && nums[i] <= g + t) {
                    return true;
                }
                treeSet.add(one);
                if(treeSet.size()>k){
                    treeSet.remove(nums[i-k]);
                }
            }
            return false;
        }
    }

//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        HashMap<Integer, Long> map = new HashMap<>();//坐标 数值，
//        for (int i = 0; i < nums.length; i++) {
//            int one = nums[i];
//            if (map.size() > 0) {
//                Iterator<Map.Entry<Integer, Long>> iterator = map.entrySet().iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<Integer, Long> next = iterator.next();
//                    Long value = next.getValue();
////                        Integer key = next.getKey();
//                    Long val = new Long(Math.abs(one - value));
//                    if (val <= t) {
//                        return true;
//                    }
//                }
//            }
//            map.put(i, new Long(one));
//            if (map.size() > k) {
//                map.remove(i - k);
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] ints = {1,5,9,1,5,9};
        int k = 2;
        int t = 3;
//        int[] ints = {-1, 2147483647};
//        int k = 1;
//        int t = 2147483647;
        boolean b = new Num220存在重复元素III().new Solution().containsNearbyAlmostDuplicate(ints, k, t);
        System.out.println(b);

//
//            // creating a TreeSet
//            TreeSet <Integer>treeadd = new TreeSet<Integer>();
//
//            // adding in the tree set
//            treeadd.add(12);
//            treeadd.add(11);
//            treeadd.add(16);
//            treeadd.add(15);
//
//            // getting ceiling value for 13
//            System.out.println("Ceiling value for 13: "+treeadd.ceiling(13));
//            System.out.println("Ceiling value for 13: "+treeadd.floor(13));
    }
}
