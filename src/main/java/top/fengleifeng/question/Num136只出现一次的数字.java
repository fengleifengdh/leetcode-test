package top.fengleifeng.question;

import top.fengleifeng.util.Constants;

import java.util.HashMap;

/**
 * @program: leetcode-test
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * * @author: fengleifeng
 * @create: 2020-08-03 17:22
 **/
public class Num136只出现一次的数字 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return hashMap.entrySet().iterator().next().getKey();
    }

    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    //方法2 用异或

    public static void main(String[] args) {
        int[] i = {2, 2, 1};
        int result = new Num136只出现一次的数字().singleNumber(i);
        System.out.println(result);
    }
}
