package org.cxz.algorithm.dynamic;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/5 18:36
 */
public class caseO1625 {
   public static class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
   }
   public static class DList{
       private Node ret;
       private int size;

       private Node tail;
       public DList(){
            this.ret = new Node(-1,-1);
            this.size=0;
       }

       public void addFirst(Node node){
            if(ret.next==null){
                ret.next = node;
                node.prev = ret;
                tail = node;
                size++;
                return;
            }
            Node p = ret.next;
            node.next =p;
            ret.next = node;
            p.prev = node;
            node.prev = ret;
            size++;
            return;
       }

       public void remove(Node node){
           if(node==tail){
               tail = tail.prev ;
           }
           Node p = node.prev;
           Node q = node.next;
           p.next = q;
           if(q!=null){
               q.prev = p;
           }
           size--;
       }

       public Node removeLast(){
           Node res = tail;
           remove(tail);
           return res;
       }
       public int size(){
           return this.size;
       }
   }


   public static class LRUCache {
        private HashMap<Integer, Node> map;
        private int cap;
        private DList cache;
        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap<>();
            this.cache = new DList();
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            Node node = map.get(key);
            int val = node.val;
            put(key,val);
            return val;
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);
            if(map.containsKey(key)){
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key,x);
            }
            else{
                if(cap == cache.size()){
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key,x);

            }

        }
   }

   public static void main(String[] args) {
       LRUCache cache = new LRUCache(2);
       cache.put(1, 1);
       cache.put(2, 2);
       int i = cache.get(1);// 返回  1
       System.out.println("i = " + i);

       cache.put(3, 3);    // 该操作会使得密钥 2 作废
       i = cache.get(2);       // 返回 -1 (未找到)
       System.out.println("i = " + i);
       cache.put(4, 4);    // 该操作会使得密钥 1 作废
       i = cache.get(1);       // 返回 -1 (未找到)
       System.out.println("i = " + i);
       i = cache.get(3);       // 返回  3
       System.out.println("i = " + i);
       i = cache.get(4);
       System.out.println("i = " + i);

   }




}


