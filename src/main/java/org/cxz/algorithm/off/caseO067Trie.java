package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/15 14:51
 */
public class caseO067Trie {
    public class TrieNode{
        public TrieNode[] next;
        public TrieNode(){
            next = new TrieNode[2];
            for (int i = 0; i < 2; i++) {
                next[i] = null;
            }
        }
    }
    public TrieNode root;

    public caseO067Trie(){
        root = new TrieNode();
    }

    public void insert(int num){
        TrieNode p = root;
        for (int i = 30; i >=0 ; i--) {
           // System.out.println("num = " + Integer.toBinaryString(num));
            //System.out.println(" num>> " + i+" = "+Integer.toBinaryString(num>>>i));
            int ind =num>>i&1;
            //System.out.println(" num>> " + i+"|1 = "+Integer.toBinaryString(num>>>i&1));

            if(p.next[ind]==null){
                p.next[ind] = new TrieNode();
            }
            p = p.next[ind];
        }
        return ;
    }

    public int getMax(int num){
        int res =0;
        TrieNode p = root;
        for (int i = 30; i >=0 ; i--) {
            int ind =(num>>i)&1;

            if(p.next[1^ind]!=null){
               // res = res^(1<<i);
                res = res|(1<<i);
            }
            p= (p.next[1^ind]!=null)?p.next[1^ind]:p.next[ind];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {14,70,53,83,49,91,36,80,92,51,66,70};
        //int[] arr = {3,10,5,25,2,8};
       // int[] arr = {4,2};
        int maximumXOR = new caseO067Trie().findMaximumXOR(arr);
        System.out.println("maximumXOR = " + maximumXOR);
    }

    public int findMaximumXOR(int[] nums) {
        caseO067Trie trie = new caseO067Trie();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,trie.getMax(nums[i]));
        }

        return ans;
    }
}
