package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 11:42
 */
public class case93 {
    public static void main(String[] args) {

    }
    HashSet<int[]> set;
    List<String> ans ;
    public List<String> restoreIpAddresses(String s) {
        int[] seg = {-1,-1,-1,-1};
        char[] arr = s.toCharArray();
        set = new HashSet<int[]>();
        ans = new ArrayList<>();
        dfs(arr,1,0,seg);
        return ans ;
    }
    public void dfs(char[] arr, int k ,int start,int[] seg){
        if(start>=arr.length){
            return;
        }
        if(k==4){
            int num =0;
            if(arr.length-start>1&&arr[start] =='0'){
                return ;//this segment start with 0 its illegal
            }
            for (int i = start; i <arr.length; i++) {
                num = num*10+(arr[i]-'0');
                if(num>255){
                    return;//illegal
                }
            }
            seg[k-1]=num;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seg.length; i++) {
                sb.append(seg[i]);
                if(i<seg.length-1){
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
            seg[k-1] =-1;
            return ;
        }
        if(seg[0]!=-1&&k==2&&(arr.length-start)>=10){
            return;
        }
        for (int i = start,num = 0; i < arr.length; i++) {
            num = num*10+(arr[i]-'0');
            if(num>255){
                return;
            }
            //why i-start must >=1?????  why ==1?
            if(i - start>=1&&arr[start]=='0'){
                return ;
            }
            seg[k-1] = num;
            if(!set.contains(seg)){
                dfs(arr,k+1,i+1,seg);
            }
            seg[k-1] = -1;
        }
        return;
    }
}
