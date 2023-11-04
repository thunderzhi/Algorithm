package org.cxz.algorithm.tire;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/25 21:36
 */
public class case421b {
    class Node{
        Node[] next;
        public Node(){
            next = new Node[2];
        }
    }
    void add(int x){
        Node p = root;
        for(int i = 30;i>=0;i--){
            int ind = (x&(1<<i))!=0?1:0;
            if(p.next[ind]==null) p.next[ind] = new Node();
            p = p.next[ind];
        }
        return;
    }
    int xor(int x){
        Node p = root;
        int s = 0;
        for(int i = 30;i>=0;i--){
            int ind = (x&(1<<i))!=0?0:1;
            if(p.next[ind]==null){
                p = p.next[ind^1];
            }
            else{
                s|=(1<<i);
                p = p.next[ind];
            }
        }
        return s;
    }

    Node root;
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int ans = 0;
        for(int x: nums){
            add(x);
            ans = Math.max(ans,xor(x));
        }
        return ans;
    }
}
