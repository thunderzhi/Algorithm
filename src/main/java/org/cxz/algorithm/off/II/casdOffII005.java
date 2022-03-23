package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/20 16:02
 */
public class casdOffII005 {

    // ver1 use bit & check common
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bit = new int[n];
        for(int i=0;i<n;i++){
            String s = words[i];
            for(int j= 0;j<s.length();j++){
                bit[i] |= (1<<s.charAt(j)-'a');
            }
        }
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if((bit[i]&bit[j])==0){
                    ans = Math.max(ans,(words[i].length()*words[j].length()));
                }
            }
        }
        return ans;
    }



}
