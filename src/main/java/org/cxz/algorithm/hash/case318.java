package org.cxz.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/26 15:26
 */
public class case318 {
    public static void main(String[] args) {

    }


    public int maxProduct1(String[] words){
        int[] mark = new int[words.length];
        for (int i =0;i<words.length;i++){
            for (int j = 0;j<words[i].length();j++){
                mark[i] |= (1 << (words[i].charAt(j)-'a'));
            }
        }
        int ans = 0;
        for(int i = 0;i<words.length;i++){
            for(int j =i+1;j<words.length;j++){
                if((mark[i]&mark[j])==1){
                    continue;
                }

                ans = Math.max(words[i].length()*words[j].length(),ans);
            }
        }
        return ans;
    }
    public int maxProduct2(String[] words) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(String w: words){
            int b = 0;
            for(int i=0;i<w.length();i++){
                b|= (1<<(w.charAt(i)-'a'));
            }
            int v = map.getOrDefault(b,0);
            if(v==0) list.add(b);
            if(v<w.length()) map.put(b,w.length());
        }
        int n = list.size(),ans = 0;
        for(int i=0;i<n;i++){
            int x = list.get(i);
            for(int j=i+1;j<n;j++){
                int y = list.get(j);
                if((x&y)==0){
                    int t = map.get(x)*map.get(y);
                    ans = Math.max(ans,t);
                }
            }
        }
        return ans;
    }

}
