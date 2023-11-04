package org.cxz.algorithm.tire;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/25 21:36
 */
public class case421 {
    class Node{
        int val;
        Node[] next;
        public Node(int v ){
            val = v;
            next = new Node[2];
            return;
        }
    }
    public void add(int[] arr){
        Node p = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<32;i++){
            int id = arr[i];
            if(p.next[id]==null) p.next[id] = new Node(id);
            p = p.next[id];
            //sb.append(id+(i<31?"->":""));
        }
        //System.out.println( sb.toString( ));
        return;
    }
    Node root;
    public int findMaximumXOR(int[] nums) {
        int n =nums.length;
        if(n==1) return 0;
        root = new Node(-1);
        //add(new int[32]);
        int ans = 0;
        for(int x:nums){
            int[] arr = new int[32];
            int sum = x,id = 31;
            while(x>0){
                arr[id--] = (x&1);
                x>>=1;
            }
            add(arr);
            int t = xor(arr,sum);
            //System.out.println(" x: "+ sum + " xor "+ t);
            ans = Math.max(ans,t^sum);
            //System.out.println(" ans: "+ ans );

        }
        return ans;
    }
    public int xor(int[] arr,int x){
        Node p = root;
        int s = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<32;i++){
            int a = arr[i], id = a^1;
            if(p.next[id]==null){
                s|= (a<<(31-i));
                p = p.next[a];
            }
            else{
                s|= (id<<(31-i));
                p = p.next[id];
            }

        }
        return s;
    }
}
