package org.cxz.algorithm.tire;

import java.util.Scanner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/9 22:07
 */
public class Trie_01 {
    private final int BASE = 26;
    public class TrieNode{
        boolean flag;// is word
        TrieNode[] next=new TrieNode[BASE];
        TrieNode(){
            flag = false;
            for (int i = 0; i <BASE ; i++) {
                next[i] =null;
            }
        }
    }
    private TrieNode root;
    public Trie_01(){
        root = new TrieNode();
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

    public static void main(String[] args) {
        Trie_01 t = new Trie_01();
        Scanner scan = new Scanner(System.in);
        while(true){
            String input = scan.nextLine();
            String[] arr = input.split(" ");
            String op = arr[0];
            String s = arr[1];
            switch (op){
                case "1":
                    t.insert(s);
                    break;
                case "2":
                    String res ="search word = "+s+", res = "+t.search(s);
                    System.out.println("res = " + res);

                    break;
            }

        }

    }
}
