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
 * @date 2021/10/26 13:54
 */
public class case187 {
    public static void main(String[] args) {

    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i =0,j=s.length()-10;i<=j;i++){
            String s1 = s.substring(i,i+10);
            map.put(s1,map.getOrDefault(s1,0)+1);
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> t : map.entrySet()){
            if(t.getValue()!=0){
                continue;
            }
            ans.add(t.getKey());
        }
        return ans;
    }
}
