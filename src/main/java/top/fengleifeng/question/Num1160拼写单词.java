package top.fengleifeng.question;

/**
 * @program: leetcode-test
 * @description: 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * 通过次数46,139提交次数67,208
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-20 15:45
 **/
public class Num1160拼写单词 {
    /**
     * 计算单词表中的chars每个字母出现的次数
     * 匹配每个单词的时候查看字母出现次数是否小于等于字母表中的出现次数
     */
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int result = 0;
            char[] dataArr = chars.toCharArray();
            int[] letterArr = new int[26];
            //初始化
            for (int i = 0; i < dataArr.length; i++) {
                int num = dataArr[i] - 97;
                letterArr[num] = letterArr[num] + 1;
            }

            for (int i = 0; i < words.length; i++) {
                String one = words[i];
                int[] oneLetterArr = new int[26];
                char[] oneArr = one.toCharArray();
                //单词的数组
                for (int j = 0; j < one.length(); j++) {
                    int num = oneArr[j] - 97;
                    oneLetterArr[num] = oneLetterArr[num] + 1;
                }
                //判断是否有足够字母
                for (int j = 0; j < 26; j++) {
                    if (letterArr[j] < oneLetterArr[j]) {
                        break;
                    }
                    if (j == 25) {
                        result = result + oneArr.length;
                    }
                }
            }

            return result;
        }
//        public
    }


    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int i = new Num1160拼写单词().new Solution().countCharacters(words, chars);
        System.out.println(i);

    }

}
