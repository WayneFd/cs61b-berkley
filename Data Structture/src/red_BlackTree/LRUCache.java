package red_BlackTree;

import java.util.HashMap;

class LRUCache {
    class dNode {
        int key;
        int value;
        dNode prev;
        dNode next;
        dNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private dNode head, tail;
    private int count, capacity;
    private HashMap<Integer, dNode> cache;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        head = new dNode(0, 0);
        head.prev = null;
        tail = new dNode(0, 0);
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            dNode curr = cache.get(key);
            move(curr);
            return curr.value;
        }
    }
    private void remove(dNode curr) {
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }
    private void add(dNode curr) {
        curr.next  = head.next;
        curr.next.prev = curr;
        curr.prev = head;
        head.next = curr;
    }

    private void move(dNode curr) {
        remove(curr);
        add(curr);
    }
    public void put(int key, int value) {
        dNode curr = new dNode(key, value);
        add(curr);
        cache.put(key, curr);
        ++count;
        if (count > capacity) {
            dNode pop = tail.prev;
            tail.prev.prev = pop.prev;
            pop.prev.next = tail;
            cache.remove(pop.key);
            count--;
        }

    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}