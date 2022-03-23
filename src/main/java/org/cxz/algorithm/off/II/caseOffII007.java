package org.cxz.algorithm.off.II;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/23 15:17
 */
public class caseOffII007 {

    // ver3
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums );
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<n;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int a = nums[i];
            int target = 0-a;
            int l=i+1,r=n-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    List<Integer> list =new ArrayList();
                    list.add(a);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                }
                else if(nums[l]+nums[r]>target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return ans;
    }

    //ver2
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Integer[] ind = new Integer[n];
        for(int i=0;i<n;i++){
            ind[i] = i;
        }
        Arrays.sort(ind,(o1,o2)->{return nums[o1]-nums[o2]; });
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<n;i++){
            if(i!=0&&nums[ind[i]]==nums[ind[i-1]]) continue;
            int a = nums[ind[i]];
            int target = 0-a;
            int l=i+1,r=n-1;
            while(l<r){
                if(nums[ind[l]]+nums[ind[r]]==target){
                    List<Integer> list =new ArrayList();
                    list.add(a);
                    list.add(nums[ind[l]]);
                    list.add(nums[ind[r]]);
                    ans.add(list);
                    while(l<r&&nums[ind[l]]==nums[ind[l+1]]){
                        l++;
                    }
                    l++;
                }
                else if(nums[ind[l]]+nums[ind[r]]>target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return ans;
    }

    //ver 1 not modify orign array
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Integer[] ind = new Integer[n];
        for(int i=0;i<n;i++){
            ind[i] = i;
        }
        Arrays.sort(ind,(o1, o2)->{return nums[o1]-nums[o2]; });
        Map<Integer, Set<Integer>> map = new HashMap();
        List<List<Integer>> ans = new ArrayList();
        List<int[]> list = new ArrayList();

        for(int i=0;i<n;i++){
            if(i!=0&&nums[ind[i]]==nums[ind[i-1]]) continue;
            int a = nums[ind[i]];
            int target = 0-a;
            find(a,map,i+1, nums,ind,target,ans);
        }
        return ans;
    }

    public void find(int a, Map<Integer,Set<Integer>> map,
                     int l,int[] nums,Integer[] ind,int sum,List<List<Integer>> ans){
        int r = ind.length-1;
        while(l<r){
            if(nums[ind[l]]+nums[ind[r]]>sum){
                r--;
            }
            else if(nums[ind[l]]+nums[ind[r]]<sum){
                l++;
            }
            else{
                if(map.get(a)==null){
                    //System.out.println("map put:");
                    map.put(a,new HashSet());
                }
                if(!map.get(a).contains(nums[ind[l]])){
                    //System.out.println("map get a contain l: "+ l);
                    map.get(a).add(nums[ind[l]]);
                    List<Integer> list =  new ArrayList();
                    list.add(a);
                    list.add(nums[ind[l]]);
                    list.add(nums[ind[r]]);
                    ans.add(list);
                }
                l++;
                r--;
            }
        }
        return ;
    }
}
