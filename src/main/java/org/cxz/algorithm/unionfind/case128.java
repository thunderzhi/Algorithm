package org.cxz.algorithm.unionfind;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/22 17:53
 */
public class case128 {
    public static void main(String[] args) {
        int[] num = {100,4,200,1,3,2};
        //int[] num = {100,4,200,1,3,2};
        int i = new case128().longestConsecutive(num);
        System.out.println("i = " + i);


    }
    public class UnionSet {
        public int n;
        public int[] fa;
        public int[] cnt;
        UnionSet(int nums){
            fa = new int[nums+1];
            cnt = new int[nums+1];
            for (int i = 0; i < fa.length; i++) {
                fa[i] = i;
                cnt[i] =1;
            }
        }
        int get(int x){
            if(fa[x]==x){
                return x;
            }
            fa[x]= get(fa[x]);
            return fa[x];
        }
        void merge(int a,int b){
            if(get(a)==get(b)){
                return;
            }
            int cnta = cnt[get(a)];
            int cntb = cnt[get(b)];
            cnt[get(b)]+=cnta;

            fa[get(a)]= get(b);

        }
    }
    public int longestConsecutive(int[] nums) {
        UnionSet u = new UnionSet(nums.length);
        HashMap<Integer,Integer> mapind = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            int a = nums[i];
            if(mapind.containsKey(a)){
                continue;
            }
            if(mapind.containsKey(a-1)){
                u.merge(mapind.get(a-1),i);
            }
            if(mapind.containsKey(a+1)){
                u.merge(mapind.get(a+1),i);
            }
            mapind.put(a,i);
        }
        int ans=0;
        for(int i = 0;i<nums.length;i++){
            if(u.get(i)==i&&u.cnt[i]>ans){
                ans= u.cnt[i];
            }
        }
        return ans;
    }
}
