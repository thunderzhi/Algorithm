package org.cxz.algorithm.tire;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: trie
 * @date 2022/2/22 22:44
 */
public class case139 {

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> dic = new ArrayList<>();
        //"cats", "dog", "sand", "and", "cat"
        dic.add("cats");
        dic.add("dog");
        dic.add("sand");
        dic.add("and");
        dic.add("cat");

        boolean b = new case139().wordBreak(s,dic);
        System.out.println("b = " + b);
    }
    public class Trie{
        public class Node{
            public boolean isword;
            public Node[] next;
            public Node(){
                this.isword = false;
                this.next = new Node[26];
                for(Node n :this.next){
                    n = null;
                }
            }
        }
        public Node root;
        public int min;
        public int max;
        public Trie(){
            root = new Node();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        public void insert(String word){
            Node p = root;
            for(int i = 0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(p.next[ind]==null){
                    p.next[ind] = new Node();
                }
                p = p.next[ind];// miss
            }
            p.isword = true;
            this.min = Math.min(this.min,word.length());
            this.max = Math.max(this.max,word.length());
            return;
        }

        public boolean search(String word,int l ,int r){
            Node p = root;
            for(int i = l;i<=r;i++){
                int ind = word.charAt(i)-'a';
                if(p.next[ind]==null){
                    return false;
                }
                else{
                    p = p.next[ind];
                }
            }
            return p.isword;
        }
    }

    // pass
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String str : wordDict){
            trie.insert(str);
        }
        System.out.println("leet is: "+trie.search("leet",0,3));
        if(s.length()<trie.min) return false;
        List<List<Integer>> mark = new ArrayList();
        for(int i=0;i<=s.length();i++){
            mark.add(new ArrayList());
        }
        process(s,mark,trie);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;// new add
//        dp[trie.min] = true;//not need
        for(int i = 1;i<dp.length;i++){
            if(dp[i]) continue;
            for(int ind :mark.get(i)){
                System.out.println("i: "+i+" ind : "+ind);
                if(dp[i]) break;
                dp[i] = dp[ind]&&(trie.search(s,ind,i-1));
            }
        }
        return dp[s.length()];
    }
    public void process(String s, List<List<Integer>> mark, Trie trie ){
        int min = trie.min;
        int max = trie.max;
        int n = s.length();
        for(int i = 0;i<=n-min;i++){//miss ==
            int right = i+min-1;//miss index -1
             while(right<n&&right-i<=max-1){// miss length  miss boundary
                if(trie.search(s,i,right)){
                    mark.get(right+1).add(i);
                }
                right++;
            }
        }
        return;
    }
}
