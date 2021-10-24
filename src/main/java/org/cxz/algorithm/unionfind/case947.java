package org.cxz.algorithm.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/23 23:59
 */
public class case947 {
    public static void main(String[] args) {


    }



    public int removeStones(int[][] stones) {
        UnionSet u = new UnionSet(stones.length);
        Map<Integer,Integer> rowmap = new HashMap<>();
        Map<Integer,Integer> colmap = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            int[] ele = stones[i];
            if(!rowmap.containsKey(ele[0])&&!colmap.containsKey(ele[1])){
                rowmap.put(ele[0],i);
                colmap.put(ele[1],i);
                System.out.println("step1  = " + i);
                continue;
            }
            if(rowmap.containsKey(ele[0])){
                System.out.println("step2_0 merge  " + i+" & "+rowmap.get(ele[0]));
                u.merge(rowmap.get(ele[0]),i);
            }
            if(colmap.containsKey(ele[1])){
                System.out.println("step2_1 merge  " + i+" & "+rowmap.get(ele[1]));
                System.out.println("step2_1  = " + i);
                u.merge(colmap.get(ele[1]),i);
            }

        }
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if(u.get(i)==i){
                cnt+=1;
            }
        }

        int ans = stones.length-cnt;
        return ans;





    }
}
