package org.cxz.algorithm.tire;

import java.util.Scanner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/10 15:01
 */
public class Trie_04 {
    private final int MAX_CNT =10000;
    private final int BASE = 26;
    private int[] base;// base array
    private int[] check;// check array
    private int cnt,root,da_root=1;// da_root init value ==1


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
    public TrieNode[] trie = new TrieNode[MAX_CNT];

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

    public int getBaseValue(int root,int[] base, int[] check){
        int b = 1;
        int flag =0;
        while (flag ==0){
            flag =1;
            b+=1;
            for (int i = 0; i < BASE; i++) {
                if (trie[root].next[i]==0){
                    continue;
                }
                if(check[b+i]==0){
                    continue;
                }
                flag =0;
                break;
            }
        }
        return b;
    }

    public int ConvertToDoubleArrayTrie(int root,int da_root,
                                        int[] base,int[] check){
        if(root ==0){
            return 0;
        }
        int max_ind = da_root;
        base[da_root] = getBaseValue(root,base,check);
        for (int i = 0; i < BASE; i++) {
            if(trie[root].next[i]==0){
                continue;
            }
            check[base[da_root]+i] =da_root;
            if(trie[trie[root].next[i]].flag==1){
                check[base[da_root]+i]=-da_root;
            }
        }
        for (int i = 0; i < BASE; i++) {
            if(trie[root].next[i]==0){
                continue;
            }
            max_ind = Math.max(max_ind,ConvertToDoubleArrayTrie(
                    trie[root].next[i],
                    base[da_root]+i,
                    base,check
            ));

        }
        return max_ind;
    }

    boolean searchDA(String word){
        int p = da_root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i)-'a';
            if(Math.abs(check[base[p]+ind])!=p){
                return false;
            }
            p = base[p]+ind;
        }
        return check[p]<0;
    }

    public static void main(String[] args) {
        Trie_04 t = new Trie_04();
        Scanner scan = new Scanner(System.in);
        t.base = new int[t.MAX_CNT];
        t.check = new int[t.MAX_CNT];
        t.clearTrie();
        String[] arr = {"kacek","hello","world","ssioal","liilsl","wzwxpll"};
        for (int i = 0; i < 6; i++) {
            //String s = scan.nextLine();
            t.insert(arr[i]);
        }
        int max = t.ConvertToDoubleArrayTrie(t.root,t.da_root,t.base,t.check);
        System.out.println("max*Integer.BYTES = " + max * Integer.BYTES);
        while(true){
            String s = scan.nextLine();
            String res1 ="search word in trie = "+s+", res = "+t.search(s);
            String res2 ="search word in DAtrie = "+s+", res = "+t.searchDA(s);
            System.out.println( res1);
            System.out.println( res2);
        }

    }

}
