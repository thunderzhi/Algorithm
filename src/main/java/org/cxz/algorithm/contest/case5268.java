package org.cxz.algorithm.contest;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/27 22:31
 */
public class case5268 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        List<List<Integer>> ans = new ArrayList();
        for(Integer i: nums2){
            set2.add(i);
        }
        List<Integer> list1 = new ArrayList();
        for(Integer i: nums1){
            if(!set2.contains(i)&&!list1.contains(i)){
                list1.add(i);
            }
            set1.add(i);
        }
        List<Integer> list2 = new ArrayList();
        for(Integer i: nums2){
            if(!set1.contains(i)&&!list2.contains(i)){
                list2.add(i);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
