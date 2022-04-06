package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 17:10
 */
public class case2179 {

    class FenwickTree{
        public int[] C;
        public int n;
        FenwickTree(int length){
            n =length;
            C = new int[n+1];
        }

        public int lowbit(int x){
            return x&(-x);
        }

        public int query(int i){
            int sum = 0;
            while(i>0){
                sum +=C[i];
                i-=lowbit(i);
            }
            return sum;
        }
        public void add(int ind ,int x){
            while(ind<=n){
                C[ind] += x;
                ind += lowbit(ind);
            }
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n= nums1.length;
        FenwickTree tree = new FenwickTree(n);
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<n;i++) map.put(nums2[i],i);
        long ans =0;
        for(int i =0;i<n;i++){
            int x = nums1[i];
            int j = map.get(x);
            int cnti = tree.query(j+1);
            int green = i-cnti;
            int cntj = n-j-green-1;
            ans += (long)(cnti)*(long)(cntj);
            tree.add(j+1,1);
        }
        return ans;
    }
}
