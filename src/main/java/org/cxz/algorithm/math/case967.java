package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/24 17:43
 */
public class case967 {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList();
        for(int i =1;i<10;i++){
            dfs(ans,n-1,i,k);
        }
        int[] arr = new int[ans.size()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    public void dfs(List<Integer> ans ,int n,int num,int k){
        if(n==0){
            ans.add(num);
            return;
        }
        int tail = num%10;
        int next = tail+k;
        if(next<10){
            dfs(ans,n-1,num*10+next,k);
        }
        next = tail-k;
        if(k!=0&&next>=0){
            dfs(ans,n-1,num*10+next,k);
        }
        return;
    }
}
