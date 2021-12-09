package org.cxz.algorithm.txt;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/9 10:20
 */
public class case003 {
    public static void main(String[] args) {
        int l = new case003().lengthOfLongestSubstring("abcabcbb");
        System.out.println("l = " + l);
    }
    //
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")){
            return 0;
        }
        int head =1 ,tail = s.length(),mid;
        while(head<tail){
            mid = (head+tail+1)>>1;
            if (check(mid,s)){
                head = mid;
            }
            else{
                tail = mid -1;
            }
        }
        return head;
    }
    boolean check(int l ,String s){
        int[] cnt = new int[256];
        int k = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(cnt[s.charAt(i)]==0){
                k+=1;
            }
            cnt[s.charAt(i)]+=1;
            if(i>=l){
                cnt[s.charAt(i-l)]-=1;
                if(cnt[s.charAt(i-l)]==0){
                    k-=1;
                }
            }
            if(k==l){
                return true;
            }
        }
        return  false;
    }
}
