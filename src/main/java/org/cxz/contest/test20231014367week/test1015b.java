package org.cxz.contest.test20231014367week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 23:58
 */
public class test1015b {
    public boolean check(String s1,String s2){
        int n = s1.length();
        // def s1<s2
        for (int i = 0; i < n; i++) {
            if(s1.charAt(i)==s2.charAt(i))continue;
            if(s1.charAt(i)>s2.charAt(i)) return false;
        }
        return true;// s1<s2
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length(),len = Integer.MAX_VALUE;
        String ans = "";
        List<Integer> indx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='1'){
                indx.add(i);
            }
        }
        for (int i = 0; i < indx.size(); i++) {
            int cur = indx.get(i);
            int j = cur,cnt = 0;//si=='1'
            while(j<n&&cnt<k){
                if(s.charAt(j)=='1') cnt++;
                j++;
            }
            System.out.println("len = " + len+" s "+s.substring(cur,j)+" cur "+cur+" j "+j);
            if(cnt==k&&(j-cur )<=len){
                len = j-cur ;
                if(j-cur<len){
                    ans = s.substring(cur,j);
                }
                else{
                    String s1 = s.substring(cur,j);
                    if(check(s1,ans)){
                        ans = s1;
                    }
                }
            }

        }
        return ans;
    }
}
