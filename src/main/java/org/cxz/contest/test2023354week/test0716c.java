package org.cxz.contest.test2023354week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/16 10:27
 */
public class test0716c {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            int t = nums.get(i);
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int x = -1,f =-1;
        for (int k : map.keySet()) {
            if(map.get(k)*2>n){
                x = k;
                f = map.get(k);
                break;
            }
        }
        System.out.println("x = " + x+" f = " + f);
        int ans=-1;
        // (n+1)/2
        int[] sum = new int[n+1];
        for (int i = 0; i < n ; i++) {
            if (nums.get(i)==x) {
                arr[i] = 1;
            }
            sum[i+1] = sum[i]+ arr[i];
        }
//        System.out.println("Arrays. = " + Arrays.toString(sum));
        for (int i = 1; i <=n; i++) {
            // A 0~i-1  area size i
            // B i~n-1 area size n-i
            if((sum[i]*2>i)&&(f-sum[i])*2>(n-i)){
                ans = i-1;
                break;
            }
        }
        return ans;
    }
    
}
