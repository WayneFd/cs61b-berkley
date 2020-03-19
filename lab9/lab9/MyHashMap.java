package lab9;

import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Wayne
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private double loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int hash = hash(key);
        ArrayMap<K, V> target = buckets[hash];
        return  target.get(key);
    }
    private void resize(int capacity) {
        ArrayMap<K, V>[] newbuckets = new ArrayMap[capacity];
        size = 0;
        for (int i = 0; i < newbuckets.length; i += 1) {
            newbuckets[i] = new ArrayMap<>();
        }
        for (int i = 0; i < buckets.length; i++) {
            for (K key : buckets[i]) {
                V value = buckets[i].get(key);
                puthelper(key, value, newbuckets);
            }
        }
        buckets = newbuckets;
    }
    /* Associates the specified value with the specified key in this map. */
    private void puthelper(K key, V value, ArrayMap<K, V>[] p) {
        if (key == null) {
            throw new  IllegalArgumentException("Ket can not be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        int hash = hash(key);
        ArrayMap<K, V> target = p[hash];
        if (target.get(key) == null) {
            size += 1;
        }
        target.put(key, value);
    }
    @Override
    public void put(K key, V value) {
        if (loadFactor() > MAX_LF) {
            resize(2 * buckets.length);
        }
        puthelper(key, value, buckets);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
