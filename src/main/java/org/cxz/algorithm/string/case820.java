package org.cxz.algorithm.string;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/26 17:30
 */
public class case820 {
    class Tire {
        class Node {
            Node[] next = new Node[26];
            boolean flag = false;
        }

        Node root = new Node();
        int inseart(String word) {
            Node p = root;
            boolean flag = false;
            for(int i = word.length()-1;i>=0;i--){
                int ind = word.charAt(i) - 'a';
                if (p.next[ind] == null) {
                    p.next[ind] = new Node();
                    flag = true;
                }
                p= p.next[ind];
            }
            p.flag = true;
            return flag ? word.length() + 1 : 0;
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Tire tire = new Tire();

        int ans = 0;
        Arrays.sort(words, (o1, o2)-> {
            return o2.length() - o1.length();
        });
        for (String word : words) {
            ans += tire.inseart(word);
        }
        return ans;
    }
}
