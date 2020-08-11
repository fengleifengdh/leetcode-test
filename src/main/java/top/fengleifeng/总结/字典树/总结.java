package top.fengleifeng.总结.字典树;

/**
 * @program: leetcode-test
 * @description: 字典树设计的核心思想是空间换时间，所以数据结构本身比较消耗空间。但它利用了字符串的共同前缀（Common Prefix）作为存储依据，以此来节省存储空间，并加速搜索时间。Trie 的字符串搜索时间复杂度为 O(m)，m 为最长的字符串的长度，其查询性能与集合中的字符串的数量无关。其在搜索字符串时表现出的高效，使得特别适用于构建文本搜索和词频统计等应用。
 * <p>
 * 字典树的性质
 * <p>
 * 根节点（Root）不包含字符，除根节点外的每一个节点都仅包含一个字符；
 * 从根节点到某一节点路径上所经过的字符连接起来，即为该节点对应的字符串；
 * 任意节点的所有子节点所包含的字符都不相同；
 * 如下图的 Trie 树中包含了字符串集合 ["Joe", "John", "Johnny", "Jane", "Jack"]。
 * <p>
 * Trie 关键词查找过程：
 * <p>
 * 每次从根结点开始搜索；
 * 获取关键词的第一个字符，根据该字符选择对应的子节点，转到该子节点继续检索；
 * 在相应的子节点上，获取关键词的第二个字符，进一步选择对应的子节点进行检索；
 * 以此类推，进行迭代过程；
 * 在某个节点处，关键词的所有字母已被取出，则读取附在该节点上的信息，查找完成。
 * 关键词的插入和查找过程的时间复杂度均为 O(key_length)，空间复杂度 O(ALPHABET_SIZE * key_length * N) ，其中 N 是关键词的数量。
 * @author: fengleifeng
 * @create: 2020-08-11 11:50
 **/
public class 总结 {
    /**
     * 自己实现
     */
    public static void main(String[] args) {
        String[] s= {"flf","is","azxc"};
        String str = "qflfisa";
        Solution solution = new Solution();
//        solution.makeTrie(s);
        int respace = solution.respace(s, str);
        System.out.println(respace);
//                .makeTrie(s);
    }
}
class Solution {
    /** 自定义一个TrieNode类型。
     * 这里不用建一个变量来存当前节点表示的字符，
     * 因为只要该节点不为null，就说明存在这个字符
     */
    class TrieNode{
        TrieNode[] childs;
        boolean isWord;
        public TrieNode(){
            childs = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;  //空白的根节点，设为全局变量更醒目
    public int respace(String[] dictionary, String sentence){
        root = new TrieNode();
        makeTrie(dictionary);   //创建字典树
        int n = sentence.length();
        int[] dp = new int[n+1];
        //这里从sentence最后一个字符开始
        for(int i=n-1; i>=0; i--){
            dp[i] = n-i;    //初始默认后面全不匹配
            TrieNode node = root;
            for(int j=i; j<n; j++){
                int c = sentence.charAt(j)-'a';
                if(node.childs[c] == null){
                    //例如"abcde",i=1,j=2 可找出长度关系
                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
                    break;
                }
                if(node.childs[c].isWord){
                    dp[i] = Math.min(dp[i], dp[j+1]);
                } else{
                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    public void makeTrie(String[] dictionary){
        for(String str: dictionary){
            TrieNode node = root;
            for(int k=0; k<str.length(); k++){
                int i = str.charAt(k)-'a';
                if(node.childs[i] == null){
                    node.childs[i] = new TrieNode();
                }
                node = node.childs[i];
            }
            node.isWord = true; //单词的结尾
        }
    }
}

//
//class TrieNode {
//    private TrieNode[] childs;
//    private boolean isWord;//是否为根节点
//
//    public TrieNode() {
//        childs = new TrieNode[26];
//        isWord = false;
//    }
//
//    public void makeTrie(String[] dictionary){
//        for(String str: dictionary){
//            TrieNode node = this;
//            for(int k=0; k<str.length(); k++){
//                int i = str.charAt(k)-'a';
//                if(node.childs[i] == null){
//                    node.childs[i] = new TrieNode();
//                }
//                node = node.childs[i];
//            }
//            node.isWord = true; //单词的结尾
//        }
//    }
//
//}
