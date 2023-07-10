package org.cxz.contest.test327week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/1/8 10:29
 */
public class test0108c {
    //BF
    public boolean isItPossible(String word1, String word2) {
        int[] m1 = new int[26],m2 = new int[26];
        int cnt1 = 0,cnt2 = 0;
        for(int i = 0;i<word1.length();i++){
            m1[word1.charAt(i)-'a']++;
        }
        for(int i = 0;i<word2.length();i++){
            m2[word2.charAt(i)-'a']++;
        }
        //if(check(m1,m1)) return true;
        for(int i = 0;i<26;i++){
            if(m1[i]==0)continue;
            for(int j = 0;j<26;j++){
                if(m2[j]==0) continue;
                m1[j]++;m2[j]--;
                m1[i]--;m2[i]++;
                if(check(m1,m2)){
                    return true;
                }
                m1[i]++;m2[i]--;
                m1[j]--;m2[j]++;
            }
        }
        return false;
    }
    public boolean check(int[] A,int[] B){
        int cnt1 = 0,cnt2 = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=0) cnt1++;
        }
        for(int i=0;i<B.length;i++){
            if(B[i]!=0) cnt2++;
        }
        return cnt1==cnt2;
    }

}
