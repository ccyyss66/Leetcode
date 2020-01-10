package main.java.leetcode146;

/**
 * 双向链表+哈希表！！！ 重点
 */

import java.util.HashMap;
import java.util.Hashtable;

class LRUCache {
    class LinkedHashMap{
        int key;
        int value;
        LinkedHashMap pre;
        LinkedHashMap next;
    }
    private HashMap<Integer, LinkedHashMap> cache =
            new HashMap<Integer, LinkedHashMap>();
    private int size;
    private int capacity;
    private LinkedHashMap head, tail;


    private void addNodeInHead(LinkedHashMap node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(LinkedHashMap node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void moveNodeToHead(LinkedHashMap linkedHashMap){
        removeNode(linkedHashMap);
        addNodeInHead(linkedHashMap);
    }
    private LinkedHashMap popTailNode(){
        LinkedHashMap node = tail.pre;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedHashMap();
        tail = new LinkedHashMap();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.get(key) == null) return -1;
        else {
            LinkedHashMap node = cache.get(key);
            moveNodeToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        LinkedHashMap node = new LinkedHashMap();
        node.key = key; node.value = value;
        if (cache.get(key) == null){
            cache.put(key,node);
            addNodeInHead(node);
            size++;
            if (size > capacity){
                cache.remove(popTailNode().key);
                size--;
            }
        }
        else {
            LinkedHashMap oddnode = cache.get(key);
            oddnode.value = value;
            moveNodeToHead(oddnode);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
