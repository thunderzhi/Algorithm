package org.cxz.algorithm.tire;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/13 10:39
 */
public class case1268 {
    public static void main(String[] args) {
        String[] pro = {"mobile","mouse","moneypot","monitor","mousepad"};
        List<List<String>> mouse = new case1268().suggestedProducts(pro, "mouse");

        for (List<String> list : mouse) {
            System.out.println("Arrays.toString(list) = " + list.toString());
        }
        //System.out.println("ts.toString() = " + Arrays.toString(mouse)  );
    }

    public class Trie{
        public class TrieNode{
            public TreeSet<String> ts;
            public TrieNode[] next;

            public TrieNode(){
                ts = new TreeSet<>();;
                next = new TrieNode[26];
                for (int i = 0; i < 26; i++) {
                    next[i] = null;
                }
            }
        }
        public TrieNode root;

        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode p = root;
            int n = word.length();
            for (int i = 0; i < n ; i++) {
                int ind = word.charAt(i) -'a';
                if (p.next[ind]==null){
                    p.next[ind] = new TrieNode();
                }
                p = p.next[ind];
                p.ts.add(word);
                if(p.ts.size()>3){
                    p.ts.pollLast();
                }
            }
            return;
        }

        public List<List<String>> search(String word){
            TrieNode p = root;
            int n = word.length();
            List<List<String>> ret = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                ArrayList<String> arr = new ArrayList<>();
                int ind = word.charAt(i) -'a';
                if (p.next[ind]==null){
                    ret.add(arr);
                    return ret;
                }
                p = p.next[ind];
                if (p!=null) {
                    for (String t : p.ts) {
                        arr.add(t);
                    }
                }
                ret.add(arr) ;
            }
            return ret;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ret = new ArrayList<>();

        Trie trie = new Trie();
        for (String s : products) {
            trie.insert(s);
        }
        ret = trie.search(searchWord);

        return ret;
    }
}
