package org.cxz.algorithm.hash;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/26 15:26
 */
public class case318 {
    public static void main(String[] args) {

    }


    public int maxProduct1(String[] words){
        int[] mark = new int[words.length];
        for (int i =0;i<words.length;i++){
            for (int j = 0;j<words[i].length();j++){
                mark[i] |= (1 << (words[i].charAt(j)-'a'));
            }
        }
        int ans = 0;
        for(int i = 0;i<words.length;i++){
            for(int j =i+1;j<words.length;j++){
                if((mark[i]&mark[j])==1){
                    continue;
                }

                ans = Math.max(words[i].length()*words[j].length(),ans);
            }
        }
        return ans;
    }

}
