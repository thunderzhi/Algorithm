package org.cxz.contest.test2023341week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/16 10:13
 */
public class test0416b {

    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> facmap = new HashMap<>();
        int topk = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==1){
                for (int j = 1; j*j <=nums[i] ; j++) {
//                    int a =
                    if(nums[i]%j==0){
                        int a = nums[i]/j;// a*j==nums[i]
                        Set<Integer> set = facmap.getOrDefault(j, new HashSet<>());
                        set.add(nums[i]);
                        facmap.put(j,set);
                        int tmpmax = Math.max(a,j);
                        topk = Math.max(tmpmax,topk);
                        if(a!=j){
                            set = facmap.getOrDefault(a,new HashSet<>());
                            set.add(nums[i]);
                            facmap.put(a,set);
                        }
                    }
                }
            }
        }
        int ans = divisors[0], cnt =0,min =divisors[0];
        for (int i = 0; i < divisors.length; i++) {
//            if(cnt==n) break;// no more bigger
            min = Math.min(min,divisors[i]);
            if(facmap.containsKey(divisors[i])){
                int x = divisors[i], sum = 0,times =1;
                if(x==1){
                    sum = n;
                    //cnt = Math.max(cnt,sum);
                    if(sum>cnt){
                        cnt = sum;
                        ans = divisors[i];
                    }
                    else if(sum==cnt){
                        ans = Math.min(ans,divisors[i]);
                    }
                    continue;
                }
                Set<Integer> s = facmap.get(x);
                for(int st : s){
                    sum += map.get(st);
                }
                System.out.println("divisors = " + divisors[i]+" sum: "+sum);
                if(sum>cnt){
                    cnt = sum;
                    ans = divisors[i];
                }
                else if(sum==cnt){
                    ans = Math.min(ans,divisors[i]);
                }
            }
        }
        if(cnt==0) return min;
        return ans;






    }
}
