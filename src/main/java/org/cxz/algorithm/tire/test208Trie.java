package org.cxz.algorithm.tire;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/15 10:33
 */
public class test208Trie {
    public class TrieNode{
        public boolean isword;//

        public  TrieNode[] next;

        public TrieNode(){
            isword = false;
            next = new  TrieNode[26];
            for (int i = 0; i < 26; i++) {
                next[i]= null;
            }
        }
    }
    public  TrieNode root;
    public test208Trie() {
        root = new  TrieNode();
    }

    public void insert(String word) {
         TrieNode p = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int ind = word.charAt(i)-'a';
            if (p.next[ind]==null){
                p.next[ind] = new  TrieNode();
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
    public static void main(String[] args) {

        test208Trie trie =  new test208Trie() ;
        List<String> arr = new ArrayList<>();
        arr.add("app");
        arr.add("apple");
        arr.add("beer");
        arr.add("add");
        arr.add("jam");
        arr.add("rental");
        for (int i = 0; i < arr.size(); i++) {
            String word = arr.get(i);
            trie.insert(word);
            String log = String.format("insert [ %s ] ",word );
            System.out.println(log);
        }

        List<String> seaarr = new ArrayList<>();
        seaarr.add("apps");
        seaarr.add("app");
        seaarr.add("ad");
        seaarr.add("applepie");
        seaarr.add("rest");
        seaarr.add("jan");
        seaarr.add("rent");
        seaarr.add("beer");
        seaarr.add("jam");
        for (int i = 0; i < seaarr.size(); i++) {
            //res = trie.search("app");
            String word = seaarr.get(i);
            String log = String.format("search %s = result %s",word,trie.search(word));
            System.out.println(log);
        }
        List<String> startarr = new ArrayList<>();
        startarr.add("apps");
        startarr.add("app");
        startarr.add("ad");
        startarr.add("applepie");
        startarr.add("rest");
        startarr.add("jan");
        startarr.add("rent");
        startarr.add("beer");
        startarr.add("jam");
        for (int i = 0; i < startarr.size(); i++) {
            //res = trie.search("app");
            String word = startarr.get(i);
            String log = String.format("startsWith %s = result %s",word,trie.startsWith(word));
            System.out.println(log);
        }
  //  ["Trie",  ,"startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//[[],   ,[""],[""],[""],[""],[""],[""],[""],[""],[""]]
    }
}
