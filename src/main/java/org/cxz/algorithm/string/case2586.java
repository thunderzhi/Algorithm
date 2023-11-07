package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/7 9:06
 */
public class case2586 {

    public boolean check(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    public boolean dcheck(char a,char b){
        return check(a)&&check(b);
    }
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        int p = left;
        while(p<=right){
            String w = words[p++];
            if(dcheck(w.charAt(0),w.charAt( w.length()-1 ))) ans++;
        }
        return ans;
    }
}
