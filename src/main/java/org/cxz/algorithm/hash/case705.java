package org.cxz.algorithm.hash;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/25 14:11
 */
public class case705 {
    public static void main(String[] args) {

    }

    class MyHashSet {
        public HashNode[] nums;
        public int cnt;
        public double factor = 3;
        public class HashNode{
            public int value;
            public HashNode next;
            HashNode(int v){
                this.value = v;
                this.next = null;
            }
            public void insert(HashNode node){
                node.next =this.next;
                this.next = node;
                return;
            }
            public void removeafter(){
                if(this.next==null){
                    return;
                }
                this.next = this.next.next;
                return;
            }
        }
        public MyHashSet() {
            nums = new HashNode[1000];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = new HashNode(0);
            }
        }

        public void expand(){
            //this = new MyHashSet();
        }

        public void add(int key) {
            if(contains(key)){
                return;
            }
            int h =  gethash(key)%nums.length;
            nums[h].insert(new HashNode(key));
            cnt+=1;
            return;
        }

        public void remove(int key) {
            if(!contains(key)){
                return;
            }
            int h = gethash(key)%nums.length;
            HashNode ph = nums[h];
            while(ph.next!=null&&ph.next.value!=key){
                ph =ph.next;
            }
            ph.removeafter();
            cnt--;
            return;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int h = gethash(key)%nums.length;
            HashNode ph = nums[h].next;
            while(ph!=null&&ph.value!=key){
                ph = ph.next;
            }
            return ph!=null;
        }

        public int gethash(int x){
            return x&0x7fffffff;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
