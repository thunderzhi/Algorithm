package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/13 16:32
 */
public class case923 {

    int Mod = (int) 1e9 + 7;
    int mod = (int) 1e9 + 7;
    // ver 1 three sum
    public int threeSumMulti(int[] arr, int target) {
        int ans = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            ans += twoSum(arr, i + 1, n - 1, target - arr[i]);
            ans %= Mod;
        }
        return ans;
    }

    int twoSum(int[] arr, int l, int r, int target){
        int ans = 0;
        while (l < r) {
            if (arr[l] + arr[r] < target) l++;
            else if (arr[l] + arr[r] > target) r--;
            else {
                if (arr[l] == arr[r]) {
                    int n = r - l + 1;
                    ans += n * (n - 1) / 2;
                    ans %= Mod;
                    break;
                }
                int l_cnt = 1;
                int r_cnt = 1;
                while (arr[l + 1] == arr[l]) {
                    l++;
                    l_cnt++;
                }
                while (arr[r - 1] == arr[r]) {
                    r--;
                    r_cnt++;
                }
                ans += l_cnt * r_cnt;
                ans %= Mod;
                l++;
                r--;
            }
        }
        return ans;
    }

    //ver 1 bymy
    public int threeSumMulti2(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans =0;
        for(int i = 0,I=n-2;i<I;i++){
            int x = arr[i];
            int two = target-x;
            ans = (ans+getcnt(arr,i+1,n-1,two))%mod;
        }
        return ans;
    }

    public int getcnt(int[] arr,int l,int r,int target){
        int cnt =0;
        while(l<r){
            if(arr[l]+arr[r]>target){
                r--;
                continue;
            }
            else if(arr[l]+arr[r]<target){
                l++;
                continue;
            }
            if(arr[l]==arr[r]){
                int n = r-l+1;
                cnt += (n*(n-1)/2)%mod;
                return cnt;
            }
            int cntl =1,cntr=1;
            while(arr[l]==arr[l+1]){
                cntl+=1;
                l++;
            }
            while(arr[r]==arr[r-1]){
                cntr+=1;
                r--;
            }
            cnt += (cntl*cntr)%mod;
            l++;r--;
        }
        return cnt;
    }
}
