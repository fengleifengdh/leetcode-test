package top.fengleifeng.other.哈希链表;

/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-28 17:49
 **/
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
    }
}
