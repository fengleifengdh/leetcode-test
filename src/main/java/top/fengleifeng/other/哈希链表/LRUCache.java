package top.fengleifeng.other.哈希链表;

import java.util.HashMap;


/**
 * @program: leetcode-test
 * @description:
 * @author: fengleifeng
 * @create: 2020-05-28 17:15
 **/
public class LRUCache {
    // key 映射到 Node(key, val)
    HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    DoubleList cache;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        //
        if(!map.containsKey(key)){
            return -1;
        }else{
            //将这个提前
            int value =  map.get(key).value;
            put(key, value);//将他提前
            return value ;
        }
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        }else{
            if(capacity==cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            map.put(key,x);
            cache.addFirst(x);
        }
    }
}
