package org.cxz.algorithm.tire;

import java.util.Scanner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/9 22:07
 */
public class Trie_03 {
    private final int BASE = 26;
    public class TrieNode{
        int flag;// is word
        int[] next=new int[BASE];
        void clear(){
            flag = 0;
            for (int i = 0; i <BASE ; i++) {
                next[i] =0;
            }
        }
    }
    public TrieNode[] trie = new TrieNode[10000];
    public int cnt;

    private int root;
    void clearTrie(){
        cnt =2;
        root =1;
        trie[root].clear();
        return;
    }
    public Trie_03(){

    }

    public boolean insert(String word){
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) -'a';
            if(p.next[ind]==null){
                p.next[ind] = new TrieNode();
            }
            p = p.next[ind];
        }
        if(p.flag){
            return false;
        }
        p.flag = true;
        return true;
    }
    public boolean search(String word){
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) -'a';
            p = p.next[ind];
            if(p==null){
                return false;
            }
        }
        return p.flag;
    }
    public void output(){
        _output(root,"");
    }
    public void _output(TrieNode root,String s ){
        if(root==null){
            return;
        }
        if(root.flag){
            System.out.println("find: " + s);
        }
        for (int i = 0; i < BASE; i++) {

            _output(root.next[i],s+(char)(i+'a'));
        }
        return;
    }
    public static void main(String[] args) {
        Trie_03 t = new Trie_03();
        Scanner scan = new Scanner(System.in);
        String[] arr = {"kacek","hello","world","ssioal","liilsl","wzwxpll"};
        for (int i = 0; i < 6; i++) {
            //String s = scan.nextLine();
            t.insert(arr[i]);
        }
        t.output();
    }
}
