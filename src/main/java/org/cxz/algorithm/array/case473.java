package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/7 15:51
 */
public class case473 {
    public static void main(String[] args) {

    }

    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);// s to boolean

        int sum =0;
        for(int i=0;i<matchsticks.length;i++){
            sum+= matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        int[] arr = new int[4];
        for(int i=0;i<arr.length;i++){
            arr[i]=sum/4;
        }
        return dfs(matchsticks.length-1,arr,matchsticks);
    }
    public boolean dfs(int ind ,int[] arr,int[] ms){
        if(ind==-1){
            return true;
        }
        for(int i = 0;i<4;i++){
            if(arr[i]<ms[ind]){
                continue;
            }
            if(arr[i]==ms[ind]||arr[i]>=ms[ind]+ms[0]){
                arr[i]-=ms[ind];
                if(dfs(ind-1,arr,ms)){
                    return true;
                }
                arr[i]+=ms[ind];
            }

        }
        return false;

    }


}
