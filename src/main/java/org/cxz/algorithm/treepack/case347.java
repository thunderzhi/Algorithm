package org.cxz.algorithm.treepack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 21:31
 */
public class case347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer integer : map.keySet()) {

            pq.offer(integer);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[][] cnt = new int[map.size()][2];//0:num  1:counts
        int p=0;
        int[] ind = new int[cnt.length];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            cnt[p] =new int[]{entry.getKey(),entry.getValue()};
            ind[p] = p;
            p++;
        }
        partion(cnt,0,cnt.length-1,k,ind,ans,0);
        return ans;
    }

    public void partion(int[][] cnt ,int l,int r,int k,int[] ind,int[] ans,int ansInd){
        if(l>r){
            return;
        }
        int x = l;
        int y = r;
        int random =l+ new Random().nextInt(r-l+1);
        if(random!=x){
            int t = ind[x];
            ind[x] = ind[random];
            ind[random] = t;
        }
        int base = ind[x];
        int baseKey = cnt[ind[x]][0];
        int baseVal = cnt[ind[x]][1];
        while(x<y){
            while(x<y&&cnt[ind[y]][1]<=baseVal){
                y--;
            }
            if(x<y){
                ind[x++] = ind[y];
            }
            while(x<y&&cnt[ind[x]][1]>=baseVal){
                x++;
            }
            if(x<y){
                ind[y--] = ind[x];
            }
        }
        ind[x] =base;
        if(k<=x-l){
            partion(cnt,l,x-1,k,ind,ans,ansInd);
        }
        else{
            for(int i=l;i<=x;i++){
                ans[ansInd++] =cnt[ind[i]][0];
            }
            partion(cnt,x+1,r,k-(x-l+1),ind,ans,ansInd);
        }
        return;
    }
    public void print(List<int[]> arr){
        StringBuffer sb = new StringBuffer();
        for(int[] x:arr){
            sb.append(" k: "+x[0]+" v: "+x[1]);
        }
        System.out.println(" cnt :"+sb.toString());
    }
}
