package org.cxz.algorithm.array;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 12:03
 */
public class case220 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};
        int k = 3;
        int t = 0;
        boolean b = new case220().dup4(arr, k, t);
        System.out.println("b = " + b);
    }
    public void del(TreeMap<Integer, Integer> m,int val){
        Integer cnt = m.get(val);
        m.put(val,cnt-1);
        if(m.get(val)==0){
            System.out.println("remove  = " + val);
            m.remove(val);
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>k){
                //移除窗口  i- k -1
                del(tm,nums[i-k-1]);
            }
            System.out.println("i = " + i);
            tm.put(nums[i], tm.getOrDefault(nums[i],0)+1);
            out(tm);
            //left
            int left=nums[i]-t;
            int right=nums[i]+t;
            if(tm.get(left)!=null&&tm.get(left)>1
                    ||tm.get(right)!=null&&tm.get(right)>1){
                System.out.println("right = " + right+" left = " + left);
                return true;
            }
            //tm.containsKey()
            tm.put(left,tm.getOrDefault(left,0));
            Integer higher = tm.higherKey(left);
            while(higher!=null&&higher<=right){
                System.out.println("higher+ = " + higher +"< right = " + right);
                if(tm.get(higher)>1){
                    System.out.println("match higher = " + higher);
                    return true;
                }
                higher = tm.higherKey(higher);
                System.out.println("get higher = " + higher);
            }

            del(tm,left);
        }
        return false;
    }
    public void del(TreeMap<Long, Integer> m,Long val){
        Integer cnt = m.get(val);
        m.put(val,cnt-1);
        if(m.get(val)==0){
            System.out.println("remove  = " + val);
            m.remove(val);
        }
    }
    public boolean dup3(int[] nums, int k, int t){
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean dup4(int[] nums, int k, int t){
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
        TreeMap<Long, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>k){
                del(tm,(long)nums[i-k-1]);
            }
            Long left = (long)nums[i]-t-1;
            Long right = (long)nums[i]+t+1;
            tm.put(left,tm.getOrDefault(left,0)+1);
            tm.put(right,tm.getOrDefault(right,0)+1);
            Long high = tm.higherKey(left);
            if(high!=null&&high<right){
                return true;
            }
            del(tm,left);
            del(tm,right);
            tm.put((long)nums[i], tm.getOrDefault((long)nums[i],0)+1);
        }
        return false;
    }

    public void out(TreeMap<Integer, Integer> m){
        StringBuilder sb = new StringBuilder();
        for (Integer i:m.keySet()){
            sb.append("key= "+i);
            sb.append(" val= "+m.get(i));
        }
        System.out.println(sb.toString());
    }
}
