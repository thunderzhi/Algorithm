package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/6 22:25
 */
public class case494 {
    HashMap<PII,Integer> map = new HashMap<>();
    public void test(){
        map.put(new PII(1,3),7);

        if(map.containsKey(new PII(1,3))){
            System.out.println("contain = " +map.get(new PII(1,3)) );

        }

    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int t = 3;

        //new case494().test();

        int targetSumWays = new case494().findTargetSumWays(nums, 3);
        System.out.println("targetSumWays = " + targetSumWays);

    }



    public class PII {
        public int i;
        public int tar;
        PII(int x,int t){
            this.i = x;
            this.tar = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            PII pii = (PII) o;
            return i == pii.i &&
                    tar == pii.tar;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, tar);
        }
    }

    public int dfs(int i,int target,int[] nums){
        if(i==nums.length){
            return target==0?1:0;
        }
        PII pii= new PII(i,target);
        if(map.containsKey(pii)){
            int tmp = map.get(pii);
            System.out.println("pii i= "+i+" tar= "+target+" in map value = "+tmp);
            return tmp;
        }
        int ans =0;
        ans += dfs(i+1,target-nums[i],nums);
        ans += dfs(i+1,target+nums[i],nums);
        System.out.println("pii put i= "+i+" tar= "+target+" value= "+ans);
        map.put(pii,ans);

        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0,target,nums);
    }
}
