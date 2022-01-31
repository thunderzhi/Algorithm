package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/31 11:48
 */
public class caseO1717 {
    public class Node{
        public Node[] next;
        public boolean isword;
        public Node(){
            next = new Node[26];
            isword = false;
        }
    }
    public class Trie{
        public Node root;
        public Trie(){
            root = new Node();
        }
        public void insert(String word){
            Node p = root;
            int n = word.length();
            for(int i =0;i<n;i++){
                int ind = word.charAt(i)-'a';
                //System.out.println("ind:"+ind);
                if(p.next[ind]==null){
                    p.next[ind] =new Node();
                }
                p = p.next[ind];
            }
            p.isword = true;
            return;
        }
        // 从 pos 开始依次向后扫，记录所有可以成词的位置i
        public void markWord(String word,
                             int pos,
                             List<List<Integer>> mark){
            Node p = root;
            int n = word.length();
            for(int i =pos;i<n;i++){
                int ind = word.charAt(i)-'a';
                p = p.next[ind];
                if(p==null){
                    break;
                }
                if(p.isword){
                    mark.get(i+1).add(pos);
                }
            }
            return ;
        }
    }

    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        int n = sentence.length();
        List<List<Integer>> mark = new ArrayList();
        for(String word: dictionary){
            trie.insert(word);
        }
        for(int i = 0;i<=n;i++){
            mark.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            trie.markWord(sentence,i,mark);
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i = 1;i<=n;i++){
            dp[i] = dp[i-1]+1;
            for(int x :mark.get(i)){
                dp[i] = Math.min(dp[i],dp[x]);
            }
        }
        return dp[n];
    }
}
