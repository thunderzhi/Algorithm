package org.cxz.algorithm.off;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/25 15:17
 */
public class caseO1717 {

    public static void main(String[] args) {
        String s = "mississippi";
        String[] t = {"is","ppi","hi","sis","i","ssippi"};

        int[][] ints = new caseO1717().multiSearch(s, t);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("i = " + Arrays.toString(ints[i]));
        }

    }

    public List<Integer> sunday(String main,String pattern){
        List<Integer> ans = new ArrayList<>();
        if(pattern.equals("")){
            return ans;
        }
        int[] lastind = new int[128];

        for (int i = 0; i < pattern.length(); i++) {
            int ind = pattern.charAt(i);
            lastind[ind] = i+1;
        }
        int lenm = main.length();
        int lenp = pattern.length();
        int i = 0;
        while( i <= lenm-lenp) {
            boolean flag = true;
            for (int j = 0; j < lenp; j++) {
                if(main.charAt(i+j)==pattern.charAt(j)){
                    continue;
                }
                flag = false;
                break;
            }
            if(flag){
                ans.add(i);
                i+=1;
            }
            else if(i+lenp>=lenm){
                break;
            }
            else{
                int newchar = main.charAt(i+lenp);
                int t = lastind[newchar];
                i +=  lenp - t+1 ;
            }
        }
        return ans;
    }

    public int[][] multiSearch(String big, String[] smalls) {
        int[][] ret = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> t = sunday(big,smalls[i]);
            ret[i] = t.stream().mapToInt(Integer::intValue).toArray();
        }
        return ret;
    }

    public ArrayList<Integer> sunday2(String s, String t) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (t.equals("")) {
            return ret;

        }
        int[] bits = new int[128];
        int s_len = s.length(), t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            bits[t.charAt(i)] = i;
        }
        for (int i = 0; i + t_len <= s_len; ) {
            boolean flag = true;
            for (int j = 0; j < t_len; j++) {
                if (s.charAt(i + j) == t.charAt(j)){
                    continue;
                }
                flag = false;
                break;
            }
            if (flag) {
                ret.add(i);
                i++;
            } else if (i + t_len >= s_len) {
                break;
            } else {
                System.out.println("gold char = " + s.charAt(i+t_len));

                System.out.println("gold char lastind = " + bits[s.charAt(i + t_len)]);

                i += t_len - bits[s.charAt(i + t_len)];
            }
        }
        return ret;
    }



}
