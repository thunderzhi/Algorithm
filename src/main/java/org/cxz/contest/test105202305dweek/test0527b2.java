package org.cxz.contest.test105202305dweek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/27 22:38
 */
public class test0527b {
    public class Trie{
        public class Node{
            Node[] next;
            boolean isword;
            public Node(){
                next = new Node[26];
            }
        }
        Node root;
        public Trie(){
            root = new Node();
        }
        public void add(String word){
            Node p = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int ind = word.charAt(i)-'a';
                if(p.next[ind]==null){
                    p.next[ind] = new Node();
                }
                p = p.next[ind];
            }
            p.isword = true;
        }

    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (String dic : dictionary) {
            trie.add(dic);
            set.add(dic);
        }
        int n = s.length(),cnt = 0;
        for (int i = 0 ; i <n ; ) {
            int j = i;
            Trie.Node p = trie.root;
            int len = 0;
            while(j<n&&p!=null){
                int ind = s.charAt(j)-'a';
                if(p.next[ind]==null) break;
                j++;
                p = p.next[ind];
                
            }



        }


    }
}
