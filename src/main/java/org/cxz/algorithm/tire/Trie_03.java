package org.cxz.algorithm.tire;

import java.util.Scanner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  use array implement a trie
 * @date 2021/12/9 22:07
 */
public class Trie_03 {
    private final int BASE = 26;
    public class TrieNode{
        int flag;//1 is word
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
    public void init(){
        for (int i = 0; i < trie.length ; i++) {
            trie[i] = new TrieNode();
        }
    }
    void clearTrie(){
        cnt =2;
        root =1;
        init();
        trie[root].clear();
        return;
    }
    public Trie_03(){

    }
    public int getNewTrienode(){
        trie[cnt].clear();
        return cnt++;
    }

    public boolean insert(String word){
        int p = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) -'a';
            if(trie[p].next[ind]==0){
                trie[p].next[ind] = getNewTrienode();
            }
            p = trie[p].next[ind];
        }
        if(trie[p].flag==1){
            return false;
        }
        trie[p].flag = 1;
        return true;
    }
    public boolean search(String word){
        int p = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) -'a';
            p = trie[p].next[ind];
            if(p==0){
                return false;
            }
        }
        return trie[p].flag==1;
    }

    public static void main(String[] args) {
        Trie_03 t = new Trie_03();
        t.clearTrie();
        Scanner scan = new Scanner(System.in);
        String[] arr = {"kacek","hello","world","ssioal","liilsl","wzwxpll"};
        for (int i = 0; i < 6; i++) {
            //String s = scan.nextLine();
            t.insert(arr[i]);
        }
        while(true){
            String s = scan.nextLine();
            String res ="search word = "+s+", res = "+t.search(s);
            System.out.println("res = " + res);

        }
        //t.output();
    }
}
