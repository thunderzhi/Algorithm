package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/10 21:26
 */
public class case2531 {

    // update
    public boolean isItPossible2(String word1, String word2) {
        int[] m1 = new int[26],m2 = new int[26];
        int cnt1 = 0,cnt2 = 0;
        for(int i = 0;i<word1.length();i++){
            m1[word1.charAt(i)-'a']++;
            if(m1[word1.charAt(i)-'a']==1) cnt1++;
        }
        for(int i = 0;i<word2.length();i++){
            m2[word2.charAt(i)-'a']++;
            if(m2[word2.charAt(i)-'a']==1) cnt2++;
        }
        //if(check(m1,m1)) return true;
        for(int i = 0;i<26;i++){
            if(m1[i]==0)continue;
            for(int j = 0;j<26;j++){
                if(m2[j]==0) continue;
                if(i==j){
                    if(cnt1==cnt2) return true;
                    continue;
                }
                int d1 = 0,d2 = 0;
                if(m1[i]==1) d1--;
                if(m1[j]==0) d1++;
                if(m2[j]==1) d2--;
                if(m2[i]==0) d2++;
                if(cnt1+d1==cnt2+d2) return true;
            }
        }
        return false;
    }
}
