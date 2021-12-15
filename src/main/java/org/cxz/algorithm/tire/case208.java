package org.cxz.algorithm.tire;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  need test
 * @date 2021/12/13 9:58
 */
public class case208 {


    public class Trie{
        public class TrieNode{
            public boolean isword;//

            public TrieNode[] next;

            public TrieNode(){
                isword = false;
                next = new TrieNode[26];
                for (int i = 0; i < 26; i++) {
                    next[i]= null;
                }
            }
        }
        public TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null){
                    p.next[ind] = new TrieNode();
                }
                p = p.next[ind];
            }
            p.isword = true;
            return;
        }

        public boolean search(String word) {
            TrieNode p = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null){
                    return false;
                }
                p = p.next[ind];
            }
            return p.isword;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                int ind = prefix.charAt(i)-'a';
                if (p.next[ind]==null){
                    return false;
                }
                p = p.next[ind];
            }
            return true;
        }
    }


}
