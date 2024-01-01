package org.cxz.contest.test20231126373week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/26 10:22
 */
public class test1126 {

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        // even  r    m[r][j] == m[r][(j+k)%n]
        // odd r    m[r][j] == m[r][(j-k+n)%n]
        k%=n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i%2==0){
                    if(mat[i][j]!= mat[i][(j+k)%n])return false;
                }
                else{
                    if(mat[i][j]!= mat[i][(j-k+n)%n])return false;
                }
            }
        }
        return true;

    }


    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        if(n<2) return 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] vsum = new int[n+1];
        int[] csum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i-1);
            if(set.contains(c)){
                vsum[i] = vsum[i-1]+1;
                csum[i] = csum[i-1];
            }
            else{
                vsum[i] = vsum[i-1];
                csum[i] = csum[i-1]+1;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >0 ; j-=2) {
                // s [i-2]   s[i-1]
                int v = vsum[i] - vsum[j-1];
                int c = csum[i] - csum[j-1];
                if(v==c &&(v*c%k==0)){
                    ans++;
                }
            }
        }
        return ans;
    }
    class Node{
        int val;
        Node next;
        Node pre;
        Node(int v){
            val = v;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        //  1 nums[i] 是否存在 nums[j]<nums[i] && nums[j]+limit>=nums[i]
        int n = nums.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i],0)+1);
        }
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            int tmp = ans[i];
            if(!tm.containsKey(tmp))


            tm.put(tmp,tm.getOrDefault(tmp,0)-1);
            if(tm.get(tmp)==0) tm.remove(tmp);
            // nums[i]- limit== tar  <=  nums[j]
            Integer ceil = tm.ceilingKey(tmp-limit);
            System.out.println("ceil = " + ceil+" tmp "+tmp);
            if(ceil==null) {
//                tm.put(tmp,tm.getOrDefault(tmp,0)-1);
//                if(tm.get(tmp)==0) tm.remove(tmp);
            }
            else{
                if(ceil.compareTo(tmp)==0){
                    // nothing
                }
                else if( ceil.compareTo(tmp)<0 ){
                    ans[i] = ceil;
                    System.out.println("swap ceil+  = " + ceil +" tmp "+tmp);
                    tm.put(tmp,tm.getOrDefault(tmp,0)+1);
                    tm.put(ceil,tm.getOrDefault(ceil,0)-1);
                    if(tm.get(ceil)==0) tm.remove(ceil);
                }
            }

        }

        return ans;
    }



    public void next(){

    }
}
