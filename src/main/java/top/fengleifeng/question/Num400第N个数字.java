package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-09-04 16:04
 **/
public class Num400第N个数字 {
    /**
     * 1-9      9个数字
     * 10-99    90个数字
     * 100-999  900个数字
     * // 首先从1-9这个区间开始，判断n位数所在的数字区间
     *         long long numNum = 9; // 定义当前位数的最大的数字
     *         int bit = 1;          // 定义当前位数
     *         long long p = 0;      // 这里作为10的幂
     *         // 这里判断直到n落入某个数字区间中
     *         while (n > numNum * bit) // 如果n的位数大于当前位数的所有数字的位数之和的话
     *         {
     *             n -= numNum * bit; // 进入到下一个区间
     *             bit++;             // 进位
     *             numNum *= 10;      // 下一个区间的最大数字
     *             p++;               // 当前位数的最开始的数的幂
     *         }
     *         p = pow(10, p); // 获取当前数字区间的最开始的数字
     *         // 从开始的数字开始加上跳过多少个数字，这里n/bit获取的是包括第一个数字开始往后走多少个数字，本来
     *         // 应该是 p += n / bit - 1; 的，但是不-1的话，待会求余的结果就是当前数字的第几位，但如果求余结果
     *         // 为0的话，说明还不到下一个数字，因此为0应该为上一个数字的最后一位
     *         p += n / bit;
     *         int idx = n % bit; // 获取目标位是当前数字的第几位，索引+1
     *         // 判断给出结果
     *         if (idx != 0)
     *         {
     *             return std::to_string(p)[idx - 1] - '0';
     *         }
     *         else
     *         {
     *             return std::to_string(p - 1).back() - '0';
     *         }
     *     }
     */
    class Solution {
        public int findNthDigit(int n) {
            long num = n;
            long numNum = 9;
            long bit = 1;
            long p = 0;
            while (num>numNum*bit){
                num = num-numNum*bit;
                bit++;
                numNum = numNum*10;
                p++;
            }
             p = (int)Math.pow(10,p);
            p = p+ num/bit;
            long idex = num%bit;
            String s = p+"";
            if(idex!=0){
                return s.charAt((int)(idex-1))-'0';
            }else{
                s = (p-1)+"";
                return s.charAt(s.length()-1)-'0';
            }

        }
    }

    public static void main(String[] args) {
        int nthDigit = new Num400第N个数字().new Solution().findNthDigit(1000000000);
        System.out.println(nthDigit);
    }
}
