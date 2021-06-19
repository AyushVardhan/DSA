package com.programming.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class CacheNode {
        int key;
        int val;
        CacheNode prev;
        CacheNode next;
    }

    static int maxCap, count = 0;
    static CacheNode head, tail;
    static Map<Integer, CacheNode> lruMap;

    public static void main(String[] args) {
        head = new CacheNode();
        tail = new CacheNode();

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;

        lruMap = new HashMap<>();

        maxCap = 5;
    }

    public LRUCache(int capacity) {

    }

    public static int get(int key) {
        CacheNode node = lruMap.get(key);
        if (node == null)
            return -1;

        moveToHead(node);
        return node.val;
    }

    private static void moveToHead(CacheNode node) {
        removeNode(node);
        addNode(node);
    }

    private static void addNode(CacheNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private static void removeNode(CacheNode node) {
        CacheNode pre = node.prev;
        CacheNode nxt = node.next;

        pre.next = nxt;
        nxt.prev = pre;
    }

    public static void set(int key, int val) {
        CacheNode node = lruMap.get(key);

        if (node == null) {
            CacheNode newNode = new CacheNode();
            newNode.val = val;
            newNode.key = key;

            lruMap.put(key, newNode);
            addNode(newNode);

            ++count;

            if (count > maxCap) {
                CacheNode leastUsed = popTail();
                lruMap.remove(leastUsed.key);
                --count;
            }

        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    private static CacheNode popTail() {
        CacheNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}
