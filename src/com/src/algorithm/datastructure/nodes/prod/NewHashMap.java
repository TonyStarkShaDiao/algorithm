package com.src.algorithm.datastructure.nodes.prod;

import org.junit.jupiter.params.ParameterizedTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 新散列映射
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/05
 */
public class NewHashMap<K, V> {
    private LinkedList<Pair<K, V>>[] data;
    private static final int COLLECT_LENGTH = 769;

    private class Pair<K, V> {
        public Pair() {
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        protected K key;
        protected V value;

    }

    public NewHashMap() {
        data = new LinkedList[COLLECT_LENGTH];
        for (int i = 0; i < COLLECT_LENGTH; i++) {
            data[i] = new LinkedList<Pair<K, V>>();
        }
    }

    public void put(K key, V value) {
        int linkListArrayIndex = this.hash(key);
        Iterator<Pair<K, V>> iterator = data[linkListArrayIndex].iterator();
        while (iterator.hasNext()) {
            Pair<K, V> currentElement = iterator.next();
            if (currentElement.getKey()==key) {
                currentElement.setValue(value);
            return;
            }
        }
        data[linkListArrayIndex].offerFirst(new Pair<K,V>(key,value));
    }

    private  int hash(Object key) {
        return key.hashCode() % COLLECT_LENGTH;
    }

    public V get(K key) {
        int linkListArrayIndex = hash(key);
        Iterator<Pair<K, V>> currentElementIterator = data[linkListArrayIndex].iterator();
        while (currentElementIterator.hasNext()) {
            Pair<K, V> currentElement = currentElementIterator.next();
            if (currentElement.getKey().hashCode()==key.hashCode()){
                return currentElement.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int linkListArrayIndex = hash(key);
        Iterator<Pair<K, V>> linkListArrayElementIterator = data[linkListArrayIndex].iterator();
        if (linkListArrayElementIterator.hasNext()) {
            Pair<K, V> next = linkListArrayElementIterator.next();
            if (next.getKey().hashCode()==key.hashCode()){
                linkListArrayElementIterator.remove();
                return;
            }
        }
    }
}

