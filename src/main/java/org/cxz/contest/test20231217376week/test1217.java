package org.cxz.contest.test20231217376week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/17 10:29
 */
public class test1217 {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        int[] cnt = new int[n*n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[grid[i][j]]++;
                if(cnt[grid[i][j]]==2) ans[0] = grid[i][j];
            }
        }
        for (int i = 1; i < cnt.length; i++) {
            if(cnt[i]==0){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(nums);
        for (int i = 0; i < n/3; i++) {
            if(nums[i*3+2]-nums[i*3]<=k){
                ans[i][0] = nums[i*3];
                ans[i][1] = nums[i*3+1];
                ans[i][2] = nums[i*3+2];
            }
            else{
                return new int[0][0];
            }
        }



        return ans;
    }

    public long minimumCost(int[] nums) {
        int n = nums.length;
        if(n==1)  return 0L;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(set.add(nums[i])){
                list.add(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int m = list.size();
        if(m ==1) return 0L;
        //m>1
//        Collections.sort(list);
        long l = 2, r = 999999998,mid = 0 ;
        long ans = Math.min(check(list,map,1),check(list,map,999999999));
        System.out.println("begin ans = " + ans );
        while(l<r){
            mid = l+ (r-l)/2;
            long costmid = check(list,map,mid);
            System.out.println(" mid "+ mid +" costmid = " + costmid+" ans "+ans+" l "+ l +" r "+ r);
            if(ispalind( mid)) ans = Math.min(costmid,ans);
            System.out.println(" updeat ans mid "+ mid +" costmid = " + costmid+" ans "+ans+" l "+ l +" r "+ r);

            long mid_1 = check(list,map,mid+1);
            System.out.println(" mid+1 "+ (mid+1) +" costmid_1 = " + mid_1);
            if( costmid > mid_1){
                l = mid+1;
                System.out.println(" costmid> costmid+1  l "+ l +" r "+ r );
            }
            else{
                // costmid <= check mid+1
                r = mid;
                System.out.println(" costmid<  costmid+1  l "+ l +" r "+ r );
            }
        }
        if(ispalind(l)){
            ans = Math.min(ans,check(list,map,l));
            return ans;
        }




        return ans;
    }
    public long get(long t){
        String s = String.valueOf(t);
        char[] arr = s.toCharArray();
        for (int i = 0,j= arr.length-1; i < j; i++,j--) {
            if(arr[i]!=arr[j]) arr[j] = arr[i];
        }
        long a = Long.parseLong(new String(arr));
        



    }


    public boolean ispalind(long x){
        long y = x,s = 0;
        while(y>0){
            s= s*10+ (y%10);
            y/=10;
        }
        return x==s;
    }
    public long check(List<Integer> arr,Map<Integer, Integer> map,long t){
        long s=0;
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            long v = map.get(x);
            v*= Math.abs(t -x);
            s+= v;
        }
        return s;
    }
}
