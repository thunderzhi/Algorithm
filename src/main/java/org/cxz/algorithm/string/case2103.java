package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/2 9:30
 */
public class case2103 {
    public int get(char c){
        if(c=='R') return 1;
        if(c=='G') return 2;
        return 4;
    }

    public int countPoints(String rings) {
        int[] cnt = new int[10];
        int len = rings.length();
        int ans = 0;
        for(int i = 0;i<len;i+=2){
            if(cnt[ rings.charAt(i+1)-'0' ]==7) continue;
            int x = get(rings.charAt(i));
            cnt[ rings.charAt(i+1)-'0' ]|= x;
            if(cnt[rings.charAt(i+1)-'0']==7) ans++;
        }

        return ans;
    }
}
