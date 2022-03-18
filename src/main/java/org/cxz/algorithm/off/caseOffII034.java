package org.cxz.algorithm.off;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/17 10:41
 */
public class caseOffII034 {



    //ver 1
    public boolean isAlienSorted1(String[] words, String order) {
        Map<Character,Integer> map = new HashMap();
        int n = words.length;
        if(n==1) return true;
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=1;i<n;i++){
            if(!compare(words[i-1],words[i],map)) return false;
        }
        return true;
    }
    //if pre < cur true
    public boolean compare(String pre,String cur,Map<Character,Integer> map){
        int m = cur.length();
        int n = pre.length();
        int leng = Math.min(m,n);
        for(int i=0;i<leng;i++){
            if( map.get(cur.charAt(i))>map.get(pre.charAt(i))){
                return true;
            }
            else if( map.get(cur.charAt(i))<map.get(pre.charAt(i))){
                return false;
            }
        }
        if(m<n) return false;
        return true;
    }



}
