package org.cxz.contest.test337week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/19 10:26
 */
public class test0319c {

    public int beautifulSubsets(int[] nums, int k) {
//        int n = nums.length;
////        int state = (1<<n)-1;
////        Set<Integer> beau = new HashSet<>();
////        Set<Integer> notbeau = new HashSet<>();
////        for (int i = 1; i <=state; i++) {
////            int cnt = Integer.bitCount(i);
////            if(cnt==1){
////                beau.add(i);
////                continue;
////            }
////            int m = i;
////            int idx = 0;
////            Map<Integer,Integer> map = new HashMap<>();
////            while(m>0){
////                if((m&(1<<idx))!=0){
////                    map.put(nums[idx], map.getOrDefault(nums[idx],0)+1);
////                    m = m^(1<<idx);
////                }
////                idx++;
////            }
////            boolean flag = true;
////            for(Integer num : map.keySet()){
////                int a = Math.abs(num)+k;
////
////                if(k==0){
////                    if(map.get(a)>1||)
////                    map.get(num)>1
////                    flag = false;
////                    break;
////                }
////                if(k>0)
////                if(set.contains(a)){
////                    notbeau.add(i);
////                    break;
////                }
////                int b = num -k;
////                if(b<0) continue;
////
////            }
                return 1;// not pass



    }
}
