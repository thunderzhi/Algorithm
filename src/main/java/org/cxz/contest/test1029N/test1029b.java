package org.cxz.contest.test1029N;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/29 22:34
 */
public class test1029b {
    public static void main(String[] args) {
        String[] test = new String[]{"adc","wzy","abc"};
        System.out.println("oddString() = " + oddString(test));
    }
    public static String oddString(String[] words) {
        int leng = words.length;
        int n = words[0].length();
        int[][] diff = new int[leng][n-1];
        TreeMap<String ,Integer> map = new TreeMap<>();
        Map<String,List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < leng; i++) {
            String w = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n - 1; j++) {
                diff[i][j] = w.charAt(j+1)-w.charAt(j);
                sb.append(diff[i][j]);
            }
            String code = sb.toString();

            if(!hmap.containsKey(code)){
                hmap.put(code,new ArrayList<>());
            }
            hmap.get(code).add(i);
            map.put(code,map.getOrDefault(code,0)+1);

        }
        String code = "";
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            if(v==1){
                code = k;
            }
        }
        return words[hmap.get(code).get(0)];
    }
}
