package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class LFUCache {

    private int capacity, minFreq;
    private Map<Integer, Node> cache;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
        } else {
            if (cache.size() == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                cache.remove(minList.removeLast().key);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            minFreq = 1;
            DoublyLinkedList newList = freqMap.getOrDefault(1, new DoublyLinkedList());
            newList.addFirst(node);
            freqMap.put(1, newList);
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);
        if (freq == minFreq && list.size == 0) minFreq++;
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }

    class Node {
        int key, value, freq;
        Node prev, next;
        
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
