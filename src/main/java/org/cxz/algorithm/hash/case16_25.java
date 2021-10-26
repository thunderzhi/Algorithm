package org.cxz.algorithm.hash;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/25 17:59
 */
public class case16_25 {
    public static void main(String[] args) {
        LRUCache cache = new case16_25.LRUCache(1);
        print(cache.head);
        cache.put(2,1);
        print(cache.head);
        int a = cache.get(2);
        print(cache.head);
        System.out.println("a1 = " + a);
        cache.put(3,2);
        print(cache.head);
        a = cache.get(2);
        print(cache.head);
        System.out.println("a2 = " + a);
//        cache.put(4,4);
//        print(cache.head);
        a = cache.get(3);
        print(cache.head);
        System.out.println("a3 = " + a);
        a = cache.get(3);
        print(cache.head);
        System.out.println("a4 = " + a);
        a = cache.get(4);
        print(cache.head);
        System.out.println("a5 = " + a);
    }

    public static void print(LRUCache.Node p){
        StringBuilder sb = new StringBuilder();
        LRUCache.Node t =p;
        while(t!=null){
            sb.append(t.data);
            sb.append("-->");
            t= t.next;
        }
        System.out.println("out => " + sb.toString());

    }


    public static class LRUCache {
        public class Node{
            public Node pre;
            public Node next;
            public int data;
            public int key;
            Node(int value,int k){
                this.key = k;
                this.data = value;
                this.pre = null;
                this.next = null;
            }
            void removethis(){
                Node pre = this.pre;
                Node next = this.next;
                if(pre!=null){
                    pre.next = next;
                }
                if(next!=null){
                    next.pre = pre;
                }
                this.pre = null;
                this.next = null;
                return;
            }
            void insertPre(Node node){
                node.next = this;
                if(this.pre!=null){
                    this.pre.next = node;
                }
                node.pre = this.pre;
                this.pre = node;
                return;
            }
        }
        public Node head;
        public Node tail;
        public int size;
        public int cap;
        public HashMap<Integer, Node> map;
        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next =tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node p = map.get(key);
                Node pre = p.pre;
                if(this.size>1){
                    p.removethis();
                    tail.insertPre(p);
                }
                return p.data;
            }
            return -1;
        }

        public void put(int key, int value) {
            /*
            * not full --> insert last

            * full---> remove head-> insert last
            *
            * */
            if(map.containsKey(key)){
                Node p = map.get(key);
                p.data = value;
                Node pre = p.pre;
                if(this.size>1){
                    p.removethis();
                    tail.insertPre(p);
                }
                return;
            }
            Node p = new Node(value,key);
            map.put(key,p);
            tail.insertPre(p);
            this.size++;
            while(this.size>this.cap){
                map.remove(head.next.key);
                head.next.removethis();
                this.size--;
            }
            return;
        }
    }

}
