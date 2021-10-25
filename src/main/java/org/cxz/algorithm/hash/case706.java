package org.cxz.algorithm.hash;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/25 16:13
 */
public class case706 {
    public static void main(String[] args) {

    }


    class MyHashMap {

        public class MapNode{
            public int key;
            public int value;
            public MapNode next;
            MapNode(int k,int v){
                this.key = k;
                this.value = v;
                this.next = null;
            }

            public void add(MapNode node){
                node.next = this.next;
                this.next = node;
                return;
            }

            public void remveafter(){
                if(this.next==null){
                    return;
                }
                this.next= this.next.next;
                return;
            }

        }
        public MapNode[] data;

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new MapNode[1000];
            for (int i =0;i<data.length;i++){
                data[i] = new MapNode(0,0);
            }
        }
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int h = hash(key)%data.length;
            MapNode ph = data[h];
            while (ph.next!=null&&ph.next.key!=key){
                ph = ph.next;
            }
            if(ph.next!=null){
                ph.next.value = value;
            }
            else{
                ph.add(new MapNode(key,value));
            }

            return;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int h = hash(key)%data.length;
            MapNode ph = data[h].next;
            while(ph!=null&&ph.key!=key){
                ph = ph.next;
            }

            return ph!=null?ph.value:-1;

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            if(get(key)==-1){
                return;
            }
            int h = hash(key)%data.length;
            MapNode ph = data[h];
            while(ph.next!=null&&ph.next.key!=key){
                ph = ph.next;
            }

            ph.remveafter();
            return;

        }

        public int hash(int k){
            return k&0x7fffffff;
        }
    }
}
