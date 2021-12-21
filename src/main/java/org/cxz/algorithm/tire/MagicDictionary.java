package org.cxz.algorithm.tire;

import org.w3c.dom.Node;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/21 15:14
 */
public class MagicDictionary {

    public class Node{
        public boolean flag;
        public Node[] next;
        Node(){
            flag = false;
            next = new Node[26];
            for (int i = 0; i < 26; i++) {
                next[i] =null;
            }
        }
    }
    public Node root;

    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            insert(dictionary[i]);
        }
    }

    public void insert(String word){
        Node p = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int ind = word.charAt(i) -'a';
            if(p.next[ind]==null){
                p.next[ind] = new Node();
            }
            p = p.next[ind];
        }
        p.flag = true;
        return;
    }

    public boolean search(String searchWord) {
        return  _search(searchWord,0,root,1);
    }

    public boolean _search(String word,int ind,Node p ,int n){
        if(ind ==word.length()){
            return p.flag&&(n==0);
        }
        int i = word.charAt(ind) -'a';

        if(p.next[i]!=null&&_search(word,ind+1,p.next[i],n)){
            return true;
        }
        if(n>0){
            for (int j = 0; j < 26; j++) {
                //search 26
                if(i==j||p.next[j]==null){
                    continue;

                }
                if(_search(word,ind+1,p.next[j],n-1)){
                    return true;
                }
            }
        }
        return false;
    }

}
