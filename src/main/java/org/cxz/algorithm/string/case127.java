package org.cxz.algorithm.string;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/28 20:46
 */
public class case127 {

    public class Node{
        String word;
        int step;
        Node(String s,int val){
            word= s;
            step = val;
        }
    }
    // ver1 BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> set = new HashSet();
        for(int i=0;i<n;i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)) return 0;
        Queue<Node> que = new LinkedList();
        que.offer(new Node(beginWord,1));
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.word.equals(endWord)) return node.step;
            char[] arr = node.word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char c = arr[i];
                for(int j=0;j<26;j++){
                    if(c-'a'==j)continue;
                    arr[i] = (char)('a'+j);
                    String t = new String(arr);
                    if(set.contains(t)){
                        set.remove(t);
                        que.offer(new Node(t,node.step+1));
                    }
                }
                arr[i] =c;
            }
        }
        return 0;
    }
}
